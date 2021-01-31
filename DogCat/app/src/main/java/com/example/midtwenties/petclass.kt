package com.example.midtwenties

class petclass(val name: String, val kind: Int) { // kind: 고양이 1, 강아지 2
    var month=0;
    var gender=0; // gender: 여자 1, 남자 2
    var character=0; // 성격에 따라 번호 매겨줘
    var hunger=0;
    var wash=0;
    var play=0;

    fun saveinfo():String{
        return String.format("%s %d %d %d %d %d %d",this.name,this.month,this.gender,this.character,this.hunger,this.wash,this.play)
    }
    fun filename():String{
        return String.format("%s.txt",this.name)
    }
}