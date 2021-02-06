package com.example.midtwenties

class PetClass (info: String) { // kind: 고양이 1, 강아지 2
    var name=""
    var kind=0
    var month=0
    var gender=0 // gender: 여자 1, 남자 2
    var character:Character=Perfect()// 성격에 따라 번호 매겨줘
    var food=0
    var wash=0
    var play=0
    var sleep=0
    var happy=0
    var health=0
    var mood=0

    init {
        val arr=info.split(" ")
        this.name=arr[0]
        this.kind=arr[1].toInt()
        this.month=arr[2].toInt()
        this.gender=arr[3].toInt()
        val num=arr[4].toInt()
        this.food=arr[5].toInt()
        this.wash=arr[6].toInt()
        this.play=arr[7].toInt()
        this.sleep=arr[8].toInt()
        this.happy=arr[9].toInt()
        this.health=arr[10].toInt()
        this.mood=arr[11].toInt()
    }

    fun saveinfo():String{
        return String.format("%s %d %d %d %d %d %d %d %d %d %d %d",this.name,this.kind,this.month,this.gender,this.character.type,this.food,this.wash,this.play,this.sleep,this.happy,this.health,this.mood)
    }

    fun filename():String{
        return String.format("%s.txt",this.name)
    }
    /*
    fun checkstate(){
        this.food-=this.character.hunger_weight.toInt()
        this.wash-=this.character.wash_weight.toInt()
        this.play-=this.character.play_weight.toInt()
    }
     */
}

open abstract class Character{

    abstract var type:Int
    abstract var hunger_weight:Float
    abstract var wash_weight:Float
    abstract var play_weight:Float
}

class Perfect:Character(){

    override var type: Int=0
    override var hunger_weight:Float=1.0F
    override var wash_weight:Float=1.0F
    override var play_weight:Float=1.0F
}

class Foodfight: Character() {

    override var type: Int=1
    override var hunger_weight:Float=3.0F
    override var wash_weight:Float=1.0F
    override var play_weight:Float=1.0F
}

class Naughty:Character(){

    override var type: Int=2
    override var hunger_weight:Float=1.0F
    override var wash_weight:Float=1.0F
    override var play_weight:Float=3.0F
}

class Cleaner:Character(){

    override var type: Int=3
    override var hunger_weight:Float=1.0F
    override var wash_weight:Float=3.0F
    override var play_weight:Float=1.0F
}