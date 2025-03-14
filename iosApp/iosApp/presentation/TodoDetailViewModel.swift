//
//  TodoDetailViewModel.swift
//  iosApp
//
//  Created by Aleš Džubera on 14.03.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import ComposeApp


class TodoDetailViewModel: ObservableObject{
    @Published var todoDetail: TodoDetail? = nil
    
    func fetchDetail(userId: Int, id: Int) async {
  
        do {
            let result: TodoDetail? = try await GetTaskDetailUseCase(userId: Int32(userId), taskId: Int32(id)).use()

            if result != nil{
                DispatchQueue.main.async {
                    self.todoDetail = result
                }
            }
         } catch {
             print("Something went wrong: \(error)")
            
         }
    }
    
    
    func complete(userId: Int, id: Int, onCompletion: () -> Unit) async {
  
        do {
            let result: Bool = try await UpdateTaskStateUseCase(userId: Int32(userId), taskId: Int32(id), newState: true).use()
                
            if result {
                onCompletion()
            }
         } catch {
             print("Something went wrong: \(error)")
            
         }
    }
   
    
  
}
