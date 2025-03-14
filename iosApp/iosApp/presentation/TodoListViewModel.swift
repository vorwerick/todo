//
//  TodoListViewModel.swift
//  iosApp
//
//  Created by Aleš Džubera on 14.03.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import ComposeApp


class TodoListViewModel: ObservableObject{
    @Published var todos: NSArray? = nil
    @Published var message: String? = nil
    
    func fetchTodos(userId: Int) async {
        
        do {
            print("LOAD")
            let result: NSArray = try await GetTasksUseCase(userId: Int32(userId)).use() as NSArray
            DispatchQueue.main.async {
                self.todos = result
            }
           
         } catch {
             print("Something went wrong: \(error)")
             DispatchQueue.main.async {
                 self.message = "Something went wrong."
             }
        
         }
    }
   
   
}
