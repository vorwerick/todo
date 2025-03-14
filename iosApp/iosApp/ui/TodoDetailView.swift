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
                
                Button("Přihlásit se") {
                    Task{
                        await viewModel.complete()
                    }
                }
                .padding()
                .buttonStyle(.borderedProminent)
                .background(.red)
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
