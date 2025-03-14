//
//  LoginView.swift
//  iosApp
//
//  Created by Aleš Džubera on 14.03.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct LoginView: View {
    var parameterAuthViewModel = AuthViewModel()
    @State var loginUserIdField: String = "1"
    
    var body: some View {
        VStack {
                   Text("Přihlášení")
                       .font(.largeTitle)
                       .padding()
            
       
            TextField("ID uživatele", text: $loginUserIdField)
                         .padding()
                         .keyboardType(.numberPad)
                         .textFieldStyle(RoundedBorderTextFieldStyle())
                   Button("Přihlásit se") {
                       Task{
                           await parameterAuthViewModel.login(userId: loginUserIdField)
                       }
                   }
                   .padding()
                   .buttonStyle(.borderedProminent)
            
            Text(parameterAuthViewModel.authMessage ?? "")
                .font(.footnote)
                .foregroundColor(.red)
               }
    }
}

#Preview {
   // LoginView()
}
