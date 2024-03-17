package com.dgController.controller.data

//data class PatternUnit_DataClass( //0.1s
//    val intensity_p: Int,//0-100
//    val frequency: Int//0-100
//)

val default_patterns = mapOf(
    "经典" to listOf(
        PatternUnit_DataClass(10, 100),
        PatternUnit_DataClass(50, 100),
        PatternUnit_DataClass(80, 100),
        PatternUnit_DataClass(100, 100),
        PatternUnit_DataClass(0, 100),
    ),

    "炼狱2.0" to List(4) {
        PatternUnit_DataClass(20, 100)
    } + List(4) {
        PatternUnit_DataClass(40, 80)
    } + List(4) {
        PatternUnit_DataClass(60, 50)
    } + List(4) {
        PatternUnit_DataClass(80, 20)
    } + List(4) {
        PatternUnit_DataClass(100, 50)
    } + List(4) {
        PatternUnit_DataClass(100, 70)
    } + List(4) {
        PatternUnit_DataClass(80, 50)
    } + List(4) {
        PatternUnit_DataClass(100, 30)
    } + List(4) {
        PatternUnit_DataClass(100, 20)
    },

    "打屁股" to List(1) {
        PatternUnit_DataClass(100, 0)
    },

    "冲击" to listOf(PatternUnit_DataClass(100, 100)),//高频

//    "test0" to listOf(PatternUnit_DataClass(100, 0)),//低频
//    "test1" to listOf(PatternUnit_DataClass(100, 10)),
//    "test2" to listOf(PatternUnit_DataClass(100, 30)),
//    "test3" to listOf(PatternUnit_DataClass(100, 40)),
//    "test4" to listOf(PatternUnit_DataClass(100, 50)),
//    "test5" to listOf(PatternUnit_DataClass(100, 60)),
//    "test6" to listOf(PatternUnit_DataClass(100, 70)),
//    "test7" to listOf(PatternUnit_DataClass(100, 90)),
//    "test8" to listOf(PatternUnit_DataClass(100, 100)),//高频
)
