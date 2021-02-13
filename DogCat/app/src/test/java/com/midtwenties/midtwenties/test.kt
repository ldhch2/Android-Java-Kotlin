package com.midtwenties.midtwenties

class Petclass(val name: String, val kind: Int) { // kind: 고양이 1, 강아지 2
    var month=0
    var gender=0 // gender: 여자 1, 남자 2
    lateinit var character:Charactor// 성격에 따라 번호 매겨줘
    var hunger=0
    var wash=0
    var play=0


    fun saveinfo():String{
        return String.format("%s %d %d %d %d %d %d",this.name,this.month,this.gender,this.character.type,this.hunger,this.wash,this.play)
    }
    fun filename():String{
        return String.format("%s.txt",this.name)
    }
}

open abstract class Charactor{

    abstract var type:Int
    abstract var hunger_weight:Float
    abstract var wash_weight:Float
    abstract var play_weight:Float
}

class Perfect:Charactor(){
    override var type: Int=0
    override var hunger_weight:Float=1.0F
    override var wash_weight:Float=1.0F
    override var play_weight:Float=1.0F
}

class Foodfight: Charactor() {

    override var type: Int=1
    override var hunger_weight:Float=3.0F
    override var wash_weight:Float=1.0F
    override var play_weight:Float=1.0F
}

class Naughty:Charactor(){

    override var type: Int=2
    override var hunger_weight:Float=1.0F
    override var wash_weight:Float=1.0F
    override var play_weight:Float=3.0F
}

class Cleaner:Charactor(){

    override var type: Int=3
    override var hunger_weight:Float=1.0F
    override var wash_weight:Float=3.0F
    override var play_weight:Float=1.0F
}
