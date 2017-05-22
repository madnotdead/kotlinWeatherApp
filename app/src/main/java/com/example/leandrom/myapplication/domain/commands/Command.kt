package com.example.leandrom.myapplication.domain.commands

/**
 * Created by leandrom on 20-May-17.
 */
public interface Command<T>{
    fun execute(): T
}