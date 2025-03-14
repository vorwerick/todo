//
//  AuthViewModel.swift
//  iosApp
//
//  Created by Aleš Džubera on 14.03.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import ComposeApp

@MainActor
class AuthViewModel: ObservableObject{
    @Published var user: User?
    @Published var authMessage: String?
    
    
    func login(userId: String) async {
  
        do {
            guard let id = Int(userId), id > 0 else {
                  authMessage = "Špatné ID"
                  return
              }
            let result: User? = try await LoginUseCase(userId: Int32(id)).use() as? User
            DispatchQueue.main.async {
                self.authMessage = ""
                if result != nil{
                    self.authMessage = "Úspěšně přihlášeno"
                    print(result)
                    self.user = result
                } else {
                    self.authMessage = "Něco se stalo"

                }
            }
           
            
         } catch {
           
             print("Something went wrong: \(error)")
             DispatchQueue.main.async {
                 self.authMessage = "Něco se stalo"
             }
            
         }
    }
    
    func logout() async{
  
        do {
            _  = try await LogoutUseCase().use()
            DispatchQueue.main.async {
                self.authMessage = ""
                self.user = nil
            }
          
         } catch {
             print("Something went wrong: \(error)")
         }
    }
}
