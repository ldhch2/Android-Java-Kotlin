package com.midtwenties.dogcat

import android.net.Uri
import androidx.core.net.toUri

class PetClass (info: String) { // kind: 고양이 1, 강아지 2
    var name=""
    var kind=0
    var month=0
    var gender=0 // gender: 여자 1, 남자 2
    var character: Character = Perfect()// 성격에 따라 번호 매겨줘
    var state: PetState = PetState()
    var card: Uri

    init {
        val arr=info.split(" ")
        this.name=arr[0]
        this.kind=arr[1].toInt()
        this.month=arr[2].toInt()
        this.gender=arr[3].toInt()
        val num=arr[4].toInt()
        card=arr[12].toUri()

        character = if (num==0) Perfect()
        else if (num==1) Foodfight()
        else if (num==2) Naughty()
        else if (num==3) Cleaner()
        else if (num==4) Lazy()
        else if (num==5) Coward()
        else Perfect()

        state= PetState(arr[5].toInt(), arr[6].toInt(), arr[7].toInt(), arr[8].toInt(), arr[9].toInt(), arr[10].toInt(), arr[11].toInt())
    }

    fun saveinfo():String{
        return String.format("%s %d %d %d %d %s %s",this.name,this.kind,this.month,this.gender,this.character.type,state.info(),card.toString())
    }

    fun filename():String{
        return String.format("%s.txt",this.name)
    }
    fun checkstate(){
        this.state.full-=this.character.full_weight
        this.state.clean-=this.character.clean_weight
        this.state.excited-=this.character.excited_weight
        this.state.awake-=this.character.awake_weight
        this.state.happy-=this.character.happy_weight
        this.state.healthy-=this.character.healthy_weight
        this.state.relaxed-=this.character.relaxed_weight
    }
}

abstract class Character{

    abstract var type:Int
    abstract val info:String

    abstract var full_weight:Int
    abstract var clean_weight:Int
    abstract var excited_weight:Int
    abstract var awake_weight:Int
    abstract var happy_weight:Int
    abstract var healthy_weight:Int
    abstract var relaxed_weight:Int
}

class Perfect: Character(){

    override var type: Int=0

    override var full_weight:Int=1
    override var clean_weight:Int=1
    override var excited_weight:Int=1
    override var awake_weight:Int=1
    override var happy_weight:Int=1
    override var healthy_weight:Int=1
    override var relaxed_weight:Int=1
    override val info= "완벽함 - 완벽한 상태입니다"
}

class Foodfight: Character() {

    override var type: Int=1

    override var full_weight:Int=1
    override var clean_weight:Int=1
    override var excited_weight:Int=1
    override var awake_weight:Int=1
    override var happy_weight:Int=1
    override var healthy_weight:Int=1
    override var relaxed_weight:Int=1

    override val info="먹보\n-\n많이 먹어요.\n자주 먹여줘야합니다."
}

class Naughty: Character(){

    override var type: Int=2
    override var full_weight:Int=1
    override var clean_weight:Int=1
    override var excited_weight:Int=1
    override var awake_weight:Int=1
    override var happy_weight:Int=1
    override var healthy_weight:Int=1
    override var relaxed_weight:Int=1

    override var info= "장난꾸러기\n-\n관심이 많이 요구됩니다."
}

class Cleaner: Character(){

    override var type: Int=3

    override var full_weight:Int=1
    override var clean_weight:Int=1
    override var excited_weight:Int=1
    override var awake_weight:Int=1
    override var happy_weight:Int=1
    override var healthy_weight:Int=1
    override var relaxed_weight:Int=1

    override var info = "깔끔쟁이\n-\n지나치게 깔끔합니다.\n목욕을 자주 시켜줘야해요."
}

class Lazy: Character(){

    override var type: Int=4

    override var full_weight:Int=1
    override var clean_weight:Int=1
    override var excited_weight:Int=1
    override var awake_weight:Int=1
    override var happy_weight:Int=1
    override var healthy_weight:Int=1
    override var relaxed_weight:Int=1

    override var info = "늘보\n-\n지나치게 게을러요.\n희한하게 관심을 덜 요구합니다."
}

class Coward: Character(){
    override var type: Int=5

    override var full_weight:Int=1
    override var clean_weight:Int=1
    override var excited_weight:Int=1
    override var awake_weight:Int=1
    override var happy_weight:Int=1
    override var healthy_weight:Int=1
    override var relaxed_weight:Int=1

    override var info = "겁쟁이\n-\n겁이 많아요.\n세상을 알아가는데\n시간이 많이 필요합니다."
}

class PetState(var full:Int=0,var clean:Int=0,var excited:Int=0,var awake:Int=0,var happy:Int=0,var healthy:Int=0,var relaxed:Int=0){
    fun info():String{
        return String.format("%d %d %d %d %d %d %d",this.full,this.clean,this.excited,this.awake,this.happy,this.healthy,this.relaxed)
    }
}