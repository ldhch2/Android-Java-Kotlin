package com.midtwenties.dogcat


class Iteminfo(val name:String){
    val kind:String
    val imagename:String
    val price:Int
    val option1:String
    val option2:String
    val option3:String
    init{
        when(name) {
            "공" -> { this.kind="toy";this.imagename = null.toString(); this.price = 500; this.option1 = "빨간색"; this.option2 = "파란색"; this.option3 = null.toString() }
            "오뚝이" -> {this.kind="toy"; this.imagename = null.toString(); this.price = 500;this.option1 = "1";this.option2 = "2"; this.option3 = "3" }
            "터그" -> { this.kind="toy";this.imagename = null.toString();this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3" }
            "낚시대" -> { this.kind="toy";this.imagename = null.toString();this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3" }
            "인형" -> { this.kind="toy";this.imagename = null.toString();this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3" }


            "기본 쿠션" -> { this.kind="house";this.imagename = "freecushion"; this.price = 500; this.option1 = "빨간색"; this.option2 = "파란색"; this.option3 = null.toString() }
            "Pink 베이직 홈" -> {this.kind="house"; this.imagename = "pinkbasichouse"; this.price = 500;this.option1 = "1";this.option2 = "2"; this.option3 = "3" }
            "Blue 베이직 홈" -> { this.kind="house";this.imagename = "bluebasichouse";this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3" }
            "Brown 베이직 홈" -> {this.kind="house"; this.imagename = "brownbasichouse";this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3" }
            "프린세스 홈" -> { this.kind="house";this.imagename = "princesshouse";this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3" }
            "[Premium] 캣타워" -> {this.kind="house"; this.imagename = "cattowerpre";this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3" }


            "멍샹푸" -> { this.kind="household";this.imagename = null.toString(); this.price = 500; this.option1 = "빨간색"; this.option2 = "파란색"; this.option3 = null.toString() }
            "냥샴푸" -> { this.kind="household";this.imagename = null.toString(); this.price = 500;this.option1 = "1";this.option2 = "2"; this.option3 = "3" }
            "칫솔" -> { this.kind="household";this.imagename = null.toString();this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3" }
            "치약" -> { this.kind="household";this.imagename = null.toString();this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3" }
            "배변푸드" -> { this.kind="household";this.imagename = null.toString();this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3" }


            "목줄" -> { this.kind="cloth";this.imagename = null.toString(); this.price = 500; this.option1 = "빨간색"; this.option2 = "파란색"; this.option3 = null.toString() }
            "심플 옷" -> {this.kind="cloth"; this.imagename = null.toString(); this.price = 500;this.option1 = "1";this.option2 = "2"; this.option3 = "3" }
            "옷옷" -> { this.kind="cloth";this.imagename = null.toString();this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3" }


            "강아지 사료" -> { this.kind="feed";this.imagename = "dogyum"; this.price = 500; this.option1 = "빨간색"; this.option2 = "파란색"; this.option3 = null.toString() }
            "고양이 사료" -> { this.kind="feed";this.imagename = "catyum"; this.price = 500;this.option1 = "1";this.option2 = "2"; this.option3 = "3" }
            "[Premium] 강아지 사료" -> { this.kind="feed";this.imagename = "dogyumpre";this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3" }
            "[Premium] 고양이 사료" -> {this.kind="feed"; this.imagename = "catyumpre";this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3" }
            "개껌 (강아지용)" -> { this.kind="feed";this.imagename = "doggum";this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3" }
            "닭가슴살 츄르 (고양이용)" -> { this.kind="feed";this.imagename = "yellowchu";this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3" }
            "연어 츄르 (고양이용)" -> { this.kind="feed";this.imagename = "orangechu";this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3" }
            "참치 츄르 (고양이용)"-> { this.kind="feed";this.imagename = "pinkchu";this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3" }
            else -> { this.kind=null.toString();this.imagename = null.toString();this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3" }
        }
    }
}