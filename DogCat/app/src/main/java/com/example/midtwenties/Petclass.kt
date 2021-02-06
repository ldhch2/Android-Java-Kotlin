package com.example.midtwenties

class PetClass (info: String) { // kind: 고양이 1, 강아지 2
    var name=""
    var kind=0
    var month=0
    var gender=0 // gender: 여자 1, 남자 2
    var character:Character=Perfect()// 성격에 따라 번호 매겨줘
    var state:PetState= PetState()
    init {
        val arr=info.split(" ")
        this.name=arr[0]
        this.kind=arr[1].toInt()
        this.month=arr[2].toInt()
        this.gender=arr[3].toInt()

        val num=arr[4].toInt()

        character = if (num==1) Perfect()
        else if (num==2) Foodfight()
        else if (num==3) Naughty()
        else if (num==4) Cleaner()
        else Perfect()

        state= PetState(arr[5].toInt(),arr[6].toInt(),arr[7].toInt(),arr[8].toInt(),arr[9].toInt(),arr[10].toInt(),arr[11].toInt())
    }

    fun saveinfo():String{
        return String.format("%s %d %d %d %d %s",this.name,this.kind,this.month,this.gender,this.character.type,state.info())
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


class PetState(var full:Int=0,var clean:Int=0,var excited:Int=0,var awake:Int=0,var happy:Int=0,var healthy:Int=0,var relaxed:Int=0){

    fun info():String{
        return String.format("%d %d %d %d %d %d %d",this.full,this.clean,this.excited,this.awake,this.happy,this.healthy,this.relaxed)
    }
}