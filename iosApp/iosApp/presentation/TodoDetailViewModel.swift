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
    
    
    func complete(userId: Int, id: Int, onSuccess: @escaping () -> Void, onError: @escaping () -> Void) async {
  
        do {
            let result: KotlinBoolean = try await UpdateTaskStateUseCase(userId: Int32(userId), taskId: Int32(id), newState: true).use()
                
            if result.boolValue {
                DispatchQueue.main.async {
                    onSuccess()
                }
            } else {
                DispatchQueue.main.async {
                    onError()
                }
            }
         } catch {
             print("Something went wrong: \(error)")
            
         }
    }
   
    
  
}
