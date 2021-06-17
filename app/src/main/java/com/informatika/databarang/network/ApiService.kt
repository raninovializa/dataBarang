package com.informatika.databarang.network

import ...

interface ApiService {
    @GET(value: "users")
    fun getUser() : Call<List<ResponseUsersItem?>>
}