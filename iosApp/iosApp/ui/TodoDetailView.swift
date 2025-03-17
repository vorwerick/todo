//
//  TodoListView.swift
//  iosApp
//
//  Created by Aleš Džubera on 14.03.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct TodoDetailView: View {
    
    var parameterUserId: Int
    var parameterId: Int
    
    @Environment(\.presentationMode) var presentationMode
    
    
    @ObservedObject var viewModel = TodoDetailViewModel()
    
    @State private var text: String = ""
    @State private var showEditDialog = false
    
    var body: some View {
        VStack {
            
           
            HStack{
                Text("Název úkolu")
                Button(action: {
                               showEditDialog = true
                           }) {
                               Image(systemName: "pencil")
                                   .font(.title)
                                   .padding()
                                   .background(Circle().fill(Color.blue))
                                   .foregroundColor(.white)
                           }
            }
            Text(viewModel.todoDetail?.title ?? "")
                .font(.title)
            if(viewModel.todoDetail?.completed == true){
                Text("Hotovo")
                    .foregroundColor(.green)
                    .font(.title)
            } else {
                Text("V řešení")
                    .foregroundColor(.orange)
                    .font(.title)
                
                Button("Vyřešit") {
                    Task{
                        await viewModel.complete(userId: parameterUserId, id: parameterId) {
                            self.presentationMode.wrappedValue.dismiss()
                        } onError: {
                            
                        }

                    }
                }
                .padding()
                .buttonStyle(.borderedProminent)
             
            }
        
        }
        .navigationTitle("Detail úkolu")
        .task{
            await viewModel.fetchDetail(userId: parameterUserId, id: parameterId)
        }
        .sheet(isPresented: $showEditDialog) {
            EditTextView(parameterId: parameterId, userId: parameterUserId, paremeterViewModel: viewModel,onSuccess:{
                Task{
                    await viewModel.fetchDetail(userId: parameterUserId, id: parameterId)
                }
            }, text: $text)
               }
    }
}

struct EditTextView: View {
    
    var parameterId: Int
    var userId: Int
    var paremeterViewModel: TodoDetailViewModel
    var onSuccess:() -> Void
    
    @Binding var text: String
    @Environment(\.dismiss) var dismiss
    @State  var errorMessage: String?
    
    
    var body: some View {
        VStack {
            Text("Upravit název")
                   .font(.headline)
                   .foregroundColor(.primary)

               TextField("Zadejte nový název", text: $text)
                   .textFieldStyle(RoundedBorderTextFieldStyle())
                   .padding()
                   .background(Color(.systemGray6))
                   .cornerRadius(10)
                   .padding(.horizontal)

               HStack {
                   Button("Zpět") {
                       dismiss()
                   }
                   .padding()
                   .background(Color.red)
                   .foregroundColor(.white)
                   .cornerRadius(8)
                   .padding(.trailing)

                   Button("Uložit") {
                       Task {
                           await paremeterViewModel.changeTitle(userId: userId, id: parameterId, newTitle: text, onSuccess: {
                               onSuccess()
                               dismiss()
                           }, onError: {
                               errorMessage = "Something went wrong"
                           })
                       }
                   }
                   .padding()
                   .background(Color.green)
                   .foregroundColor(.white)
                   .cornerRadius(8)
               }
            .padding()
            if errorMessage != nil{
                Text("Něco se pokazilo")
                .foregroundColor(.red)
            }
        }
        .padding()
    }
}


#Preview {
    //TodoListView()
}
