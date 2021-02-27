package com.midtwenties.dogcat

class toy(name:String){
    val imagename:String ;val price:Int ;val option1:String ;val option2:String ;val option3:String

    init{
        when(name) {
            "공" -> {
                this.imagename = null.toString(); this.price = 500; this.option1 = "빨간색"; this.option2 = "파란색"; this.option3 = null.toString()
            }
            "삑삑이" -> {
                this.imagename = null.toString(); this.price = 500;this.option1 = "1";this.option2 = "2"; this.option3 = "3"
            }
            "뾱뾱이" -> {
                this.imagename = null.toString();this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3"
            }
            "공공공" -> {
                this.imagename = null.toString();this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3"
            }
            else -> {
                this.imagename = null.toString();this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3"
            }
        }
    }
}
class house(name:String){
    val imagename:String ;val price:Int ;val option1:String ;val option2:String ;val option3:String
    init{
        when(name) {
            "공" -> {
                this.imagename = null.toString(); this.price = 500; this.option1 = "빨간색"; this.option2 = "파란색"; this.option3 = null.toString()
            }
            "삑삑이" -> {
                this.imagename = null.toString(); this.price = 500;this.option1 = "1";this.option2 = "2";this.option3 = "3"
            }
            "뾱뾱이" -> {
                this.imagename = null.toString()
                this.price = 500
                this.option1 = "1"
                this.option2 = "2"
                this.option3 = "3"
            }
            "공공공" -> {
                this.imagename = null.toString()
                this.price = 500
                this.option1 = "1"
                this.option2 = "2"
                this.option3 = "3"
            }
            else -> {
                this.imagename = null.toString()
                this.price = 500
                this.option1 = "1"
                this.option2 = "2"
                this.option3 = "3"
            }
        }
    }
}
var bowlList = arrayListOf<StoreContacts>(
        StoreContacts("", "그릇 세트", 500, "구매", "빨강색", "파란색", ""),
        StoreContacts("", "밥그릇", 500, "구매", "빨강색", "파란색", "초록색"),
        StoreContacts("", "물그릇", 500, "구매", "빨강색", "파란색", "초록색"),
        StoreContacts("", "밥밥", 500, "구매", "빨강색", "파란색", "초록색"),
        StoreContacts("", "물물", 500, "구매", "빨강색", "파란색", "초록색")
)

var feedList = arrayListOf<StoreContacts>(
        StoreContacts("dogyum", "강아지 사료", 10000, "구매", "1kg", "3kg", "5kg"),
        StoreContacts("catyum", "고양이 사료", 10000, "구매", "1kg", "3kg", "5kg"),
        StoreContacts("dogyumpre", "[Premium] 강아지 사료", 15000, "구매", "1kg", "3kg", "5kg"),
        StoreContacts("catyumpre", "[Premium] 고양이 사료", 15000, "구매", "1kg", "3kg", "5kg"),
        StoreContacts("doggum", "개껌 (강아지용)", 500, "구매", "", "", ""),
        StoreContacts("yellowchu", "닭가슴살 츄르 (고양이용)", 500, "구매", "", "", ""),
        StoreContacts("orangechu", "연어 츄르 (고양이용)", 500, "구매", "", "", ""),
        StoreContacts("pinkchu", "참치 츄르 (고양이용)", 500, "구매", "", "", "")
)

var clothesList = arrayListOf<StoreContacts>(
        StoreContacts("", "심플 옷", 500, "구매", "빨강색", "파란색", ""),
        StoreContacts("", "목줄", 500, "구매", "빨강색", "파란색", "초록색"),
        StoreContacts("", "옷옷", 500, "구매", "빨강색", "파란색", "초록색")
)

class bowl(imagename: String,name:String,price: Int,option1: String,option2: String,option3: String)

class cloth(imagename: String,name: String,price: Int,option1: String,option2: String,option3: String)

class feed(imagename: String,name: String,price: Int,option1: String,option2: String,option3: String)

