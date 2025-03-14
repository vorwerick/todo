//
//  TodoListView.swift
//  iosApp
//
//  Created by Aleš Džubera on 14.03.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import ComposeApp

struct TodoListView: View {
    
    
    var parameterUserId: Int
    var parameterAuthViewModel: AuthViewModel
    
    @StateObject var viewModel = TodoListViewModel()

    var body: some View {
        if #available(iOS 16.0, *) {
            NavigationStack {
                VStack{
                    let list = viewModel.todos as? [TodoDetail]
                    if list != nil{
                        if(list!.count > 0){
                            List(list!, id: \.self) { todo in
                                NavigationLink(destination: TodoDetailView(parameterUserId: parameterUserId, parameterId: Int(todo.id))) {
                                    Text(todo.title)
                                }
                            }
                        } else {
                            Text("Žádné úkoly")
                                .font(.title)
                                .foregroundColor(.gray)
                                .frame(maxWidth: .infinity, maxHeight: .infinity)
                                .multilineTextAlignment(.center)
                        }
                    } else {
                        if(viewModel.message != nil){
                            Text(viewModel.message!)
                                .font(.title)
                                .foregroundColor(.red)
                                .frame(maxWidth: .infinity, maxHeight: .infinity)
                                .multilineTextAlignment(.center)
                        } else {
                            ProgressView()
                                .progressViewStyle(CircularProgressViewStyle())
                                .frame(width: 100, height: 100)
                        }
                      
                    }
                    
                    
                    
                }
                .navigationTitle("Úkoly")
                .toolbar {
                    ToolbarItem(placement: .navigationBarTrailing) {
                        Button("Odhlásit se") {
                            Task {
                                await parameterAuthViewModel.logout()
                            }
                        }
                    }
                }
                .onAppear {
                    Task{
                        await viewModel.fetchTodos(userId: parameterUserId)
                    }
                }
            }
        } else {
            Text("Nepodporovaná verze systému, musíš mít 16.0 a víc")
        }
    }
}

#Preview {
   // TodoListView()
}
