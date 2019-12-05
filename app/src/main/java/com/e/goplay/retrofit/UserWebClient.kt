package com.e.goplay.retrofit

import com.e.goplay.model.User


class UserWebClient {

    fun list(success: (users: List<User>) -> Unit,
             failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().userService().list()
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }


    fun insert(user: User, success: (user: User) -> Unit,
               failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().userService().insert(user)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

    fun valida(user: String, success: (user: User) -> Unit,
               failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().userService().valida(user)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }


    fun alter(user: User, success: (user: User) -> Unit,
              failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().userService().alter(user.id,user)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

}