package com.midtwenties.dogcat

class Missionclass(check :Int){
    var Mission_num:Int
    var Mission_content:String
    var Mission_daily_max:Int
    var Mission_daily_now:Int
    var Mission_total_max:Int
    var Mission_total_now:Int


    init {
        when(check){
            1->{this.Mission_num=1; this.Mission_content="산책"; this.Mission_daily_max=5;this.Mission_daily_now=0;this.Mission_total_max=100;this.Mission_total_now=0}
            2->{this.Mission_num=1; this.Mission_content="밥"; this.Mission_daily_max=5;this.Mission_daily_now=0;this.Mission_total_max=100;this.Mission_total_now=0}
            3->{this.Mission_num=1; this.Mission_content="놀아주기"; this.Mission_daily_max=5;this.Mission_daily_now=0;this.Mission_total_max=100;this.Mission_total_now=0}
            4->{this.Mission_num=1; this.Mission_content="쓰다듬기"; this.Mission_daily_max=5;this.Mission_daily_now=0;this.Mission_total_max=100;this.Mission_total_now=0}
            5->{this.Mission_num=1; this.Mission_content="마당 산책"; this.Mission_daily_max=5;this.Mission_daily_now=0;this.Mission_total_max=100;this.Mission_total_now=0}
            6->{this.Mission_num=1; this.Mission_content="씻기"; this.Mission_daily_max=5;this.Mission_daily_now=0;this.Mission_total_max=100;this.Mission_total_now=0}
            7->{this.Mission_num=1; this.Mission_content="영양제 섭취"; this.Mission_daily_max=5;this.Mission_daily_now=0;this.Mission_total_max=100;this.Mission_total_now=0}
            8->{this.Mission_num=1; this.Mission_content="광고 보기"; this.Mission_daily_max=5;this.Mission_daily_now=0;this.Mission_total_max=100;this.Mission_total_now=0}
            9->{this.Mission_num=1; this.Mission_content="검진"; this.Mission_daily_max=5;this.Mission_daily_now=0;this.Mission_total_max=100;this.Mission_total_now=0}
            else->{this.Mission_num=1; this.Mission_content="설정 바꾸기"; this.Mission_daily_max=5;this.Mission_daily_now=0;this.Mission_total_max=100;this.Mission_total_now=0}
        }
    }

    fun mission_total_new(){
        if(Mission_daily_max == Mission_daily_now){
            Mission_daily_max = Mission_total_max*2
        }
    }
}