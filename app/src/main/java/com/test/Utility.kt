package com.test


object Utility {

    fun getPersonList() : ArrayList<Person>{
        val list = ArrayList<Person>()
        list.add(Person("Sateesh",25,25000.0))
        list.add(Person("Ramesh",25,25000.0))
        list.add(Person("Dareppa",25,25000.0))
        list.add(Person("Sunil",25,25000.0))
        list.add(Person("Santu",25,25000.0))
        return list
    }
}