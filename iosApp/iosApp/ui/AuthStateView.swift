//
//  LoginView.swift
//  iosApp
//
//  Created by Aleš Džubera on 14.03.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct AuthStateView: View {
    @StateObject var authViewModel = AuthViewModel()
       
       var body: some View {
           VStack {
               if let user = authViewModel.user {
                   TodoListView(parameterUserId: Int(user.id), parameterAuthViewModel: authViewModel)
               } else {
                   LoginView(parameterAuthViewModel: authViewModel)
               }
           }
       }
}

#Preview {
   // AuthStateView()
}
