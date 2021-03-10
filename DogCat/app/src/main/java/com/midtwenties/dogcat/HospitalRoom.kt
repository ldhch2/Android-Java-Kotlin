package com.midtwenties.dogcat

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_hospital_room.*
import kotlinx.android.synthetic.main.activity_user_name.*

class HospitalContacts (var name: String, var price: Int, var buy : String, var effects : String)

class HospitalRoom : AppCompatActivity() {
    var injectionList = arrayListOf<HospitalContacts>(
            HospitalContacts("종합예방접종", 500, "구매", "개 홍역, 전염성 간염, 파보 바이러스 장염, 파라인플루엔자성 기관지염 및 랩토스피라증 등 다섯가지 질병에 대한 예방접종이다."),
            HospitalContacts("켄넬 코프 예바아접종", 300, "구매", "강아지들이 많이 모여 있는 곳에서 주로 쉽게 감염된다. 아주 심한 마른 기침을 하며, 가끔 폐렴으로 진행되기도 한다."),
            HospitalContacts("광견병 예방접종",200,"구매","야생 온혈동물에게 물릴경우 감염된다. 행동이 난폭하게 변화하고 공격적으로 변화하게 된다."),
            HospitalContacts("기생충 구제",200,"구매","장내 기생충에 감염되면 설사와 구토로 인한 영양손실과 빈혈 등으로 발육이 저하되거나 쇠약해져서 다른 질환에 쉽게 감염되게 된다."),
            HospitalContacts("심장 사상충",300,"구매","모기를 매개체로해서 호흡계, 순환계, 비뇨기계 등 신체 전반에 장애를 가져오는 질환이다.")
    )
    var nutritionList = arrayListOf<HospitalContacts>(
            HospitalContacts("종합비타민", 100, "구매", "제품에 표기된 정량만 급여해주세요. 비타민의 과다 급여는 강아지에게 치명적일 수 있습니다."),
            HospitalContacts("프로바이오틱스", 200, "구매", "대장 내 유익균의 번식을 촉진해서 장운동을 활발하게 하고, 변비를 예방하며, 체내에 남아있는 독소를 제거합니다."),
            HospitalContacts("테라코드", 50, "구매", "테라코트는 강아지 피모 영앙제로 강아지의 피부와 모발의 상태를 증진시켜줍니다. 피부의 치유, 피부탄력을 증가시켜줍니다."),
            HospitalContacts("밀크시슬", 100, "구매", "밀크시슬은 간 기능 개선에 도움을 줍니다. 독성물질에 의한 간 세포의 손상을 재생시키는데 큰 도움을 주며, 간 세포가 독성물질에 의해서 손상되는 것을 방지합니다."),
            HospitalContacts("글루코사민", 200, "구매", "글루코사민은 퇴행성 관절염과 관절 장애, 관절 통증에 효과가 있습니다."),
            HospitalContacts("항산화제",100,"구매","항산화제는 강아지 몸 속의 활성 산소를 억제합니다. 나이가 들수록 활성산소가 많아지기 때문에 나이가 들수록 항산화제를 꾸준히 먹는게 좋습니다.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_room)

        val right = AnimationUtils.loadAnimation(this, R.anim.pull_in_right)
        val left = AnimationUtils.loadAnimation(this, R.anim.pull_in_left)
        shot.visibility= View.INVISIBLE
        inject.visibility=View.INVISIBLE

        supportFragmentManager.beginTransaction()
            .replace(R.id.coin, CoinView())
            .commit()

        backButton.setOnClickListener {
            onBackPressed()
        }

        var type = intent.getIntExtra("room", 0)
        if(type == 1) {
            val roomType = findViewById<TextView>(R.id.RoomType)
            roomType.text = "주사실"
            val roomText = findViewById<TextView>(R.id.RoomText)
            roomText.text = "주사를 선택해주세요."

            var buyItem = com.midtwenties.dogcat.buyItem()
            val adapter = NutritionListAdapter(this, injectionList, buyItem)
            NutritionRecyclerview.adapter = adapter

            inject.setOnClickListener {
                if (adapter.flag == true) {
                    shot.visibility = View.VISIBLE
                    shot.startAnimation(right)
                }
            }

        } else if(type == 2) {
            val roomType = findViewById<TextView>(R.id.RoomType)
            roomType.text = "영양제실"
            val roomText = findViewById<TextView>(R.id.RoomText)
            roomText.text = "영양제를 선택해주세요."

            var buyItem = com.midtwenties.dogcat.buyItem()
            val adapter = NutritionListAdapter(this, nutritionList, buyItem)
            NutritionRecyclerview.adapter = adapter

            if (buyItem.getName() == "") {
                Toast.makeText(this, "영양제를 구매해주세요.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "영양제 사용.", Toast.LENGTH_LONG).show()
            }
        }


        val lay = LinearLayoutManager(this)
        NutritionRecyclerview.layoutManager = lay
        NutritionRecyclerview.setHasFixedSize(true)
    }
}

class buyItem {
    private var itemName = ""
    private var itemPrice = 0
    fun changeName(name: String) {
        itemName = name
    }
    fun changePrice(price: Int) {
        itemPrice = price
    }
    fun getName() : String { return itemName }
    fun getPrice() : Int { return itemPrice }
}

class NutritionListAdapter(val context: Context, val itemList : ArrayList<HospitalContacts>, var BuyItem : buyItem) :
    RecyclerView.Adapter<NutritionListAdapter.Holder>() {
    var flag = false
    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val itemname = itemView?.findViewById<TextView>(R.id.itemname)
        val price = itemView?.findViewById<TextView>(R.id.price)
        val buybutton = itemView?.findViewById<Button>(R.id.buybutton)
        val effects = itemView?.findViewById<TextView>(R.id.effects)

        fun bind(item: HospitalContacts, bindcontext: Context) {
            itemname?.text = item.name
            price?.text = item.price.toString()
            buybutton?.text = item.buy
            effects?.text = item.effects

            buybutton?.setOnClickListener {
                if(flag == false) {
                    val dialog = CustomDialog(context)
                    dialog.hospitalDig(item.name, item.price.toString())

                    dialog.setOnClickedListener(object : CustomDialog.CustomDialogListener {
                        override fun onClicked(content: String) {
                            if (content == "0") {
                                return
                            } else if (content == "1") {
                                flag = true
                                buybutton?.setBackgroundResource(R.drawable.brown_button)
                                buybutton?.setText("구매완료")
                                BuyItem.changeName(item.name)
                                BuyItem.changePrice(item.price)
                            }
                        }
                    })
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.activity_hospital_contacts, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(itemList[position], context)
    }
}