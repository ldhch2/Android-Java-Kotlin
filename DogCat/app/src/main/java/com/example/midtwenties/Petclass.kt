package com.example.midtwenties

class Petclass (info: String) { // kind: 고양이 1, 강아지 2
    var name=""
    var kind=0
    var month=0
    var gender=0 // gender: 여자 1, 남자 2
    var character:Charactor=Perfect()// 성격에 따라 번호 매겨줘
    var hunger=0
    var wash=0
    var play=0

    init {
        val arr=info.split(" ")
        this.name=arr[0]
        this.kind=arr[1].toInt()
        this.month=arr[2].toInt()
        this.gender=arr[3].toInt()
        val num=arr[4].toInt()
        this.hunger=arr[5].toInt()
        this.wash=arr[6].toInt()
        this.play=arr[7].toInt()
    }

    constructor(info:String, num:Int):this(info){
        //else if (num==4)this.character=
    }

    fun saveinfo():String{
        return String.format("%s %d %d %d %d %d %d %d",this.name,this.kind,this.month,this.gender,this.character.type,this.hunger,this.wash,this.play)
    }

    fun filename():String{
        return String.format("%s.txt",this.name)
    }

    fun checkstate(){
        this.hunger-=this.character.hunger_weight.toInt()
        this.wash-=this.character.wash_weight.toInt()
        this.play-=this.character.play_weight.toInt()
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