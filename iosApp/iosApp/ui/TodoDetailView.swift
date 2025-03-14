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
    
    
    @StateObject var viewModel = TodoDetailViewModel()
    
    var body: some View {
        VStack {
            
            Text("Název úkolu")
            Text(viewModel.todoDetail?.title ?? "")
                .font(.title)
            if(viewModel.todoDetail?.completed == true){
                Text("Hotovo")
                    .foregroundColor(.green)
            } else {
                Text("V řešení")
                    .foregroundColor(.orange)
                
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
        .navigationTitle("Datail úkolu")
        .task{
            await viewModel.fetchDetail(userId: parameterUserId, id: parameterId)
        }
    }
}

#Preview {
    //TodoListView()
}
