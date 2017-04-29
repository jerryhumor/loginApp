package com.hdu.chenpengfei.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class SelectActivity extends AppCompatActivity {

    private RecyclerView rvLandscapeList;
    private List<String> landscapeNameList;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        rvLandscapeList = (RecyclerView) findViewById(R.id.landscape_list);
        toolbar = (Toolbar) findViewById(R.id.select_toolbar);
        setSupportActionBar(toolbar);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvLandscapeList.setLayoutManager(layoutManager);

        initData();
        initLandscapeData();

        LandscapeAdapter reminderAdapter = new LandscapeAdapter(landscapeNameList);
        rvLandscapeList.setAdapter(reminderAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.select_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.login :
                startActivityForResult(new Intent(SelectActivity.this, LoginActivity.class), 0);
                break;
            case R.id.register:
                startActivityForResult(new Intent(SelectActivity.this, RegisterActivity.class), 0);
                break;
            default:break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(resultCode){
            case RESULT_OK:
                Toast.makeText(SelectActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }
    }

    public class LandscapeAdapter extends RecyclerView.Adapter<LandscapeAdapter.ViewHolder>{
        private List<String> landscapeList;

        public LandscapeAdapter(List<String> list){
            landscapeList = list;
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            TextView tvTitle;

            public ViewHolder(View view){
                super(view);
                tvTitle = (TextView) view.findViewById(R.id.tv_title);

                tvTitle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int id = ViewHolder.this.getAdapterPosition();
                        Log.d("aaa", "click" + id);
                        Intent intent = new Intent(SelectActivity.this, LandscapeActivity.class);
                        intent.putExtra("id", id+1);
                        startActivity(intent);
                    }
                });
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.landscape_item, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.tvTitle.setText(landscapeList.get(position));
        }

        @Override
        public int getItemCount() {
            return landscapeList.size();
        }
    }

    public void initData(){

        landscapeNameList = new ArrayList<>();
        landscapeNameList.add("一、长虹揽月");
        landscapeNameList.add("二、巨碟邀星");
        landscapeNameList.add("三、雅湖云影");
        landscapeNameList.add("四、书海风荷");
        landscapeNameList.add("五、兰亭春晓");
        landscapeNameList.add("六、艺苑秋歌");
        landscapeNameList.add("七、丛鱼听学");
        landscapeNameList.add("八、三省问天");
        landscapeNameList.add("九、藤廊寄梦");
        landscapeNameList.add("十、麦野浮金");

    }

    public void initLandscapeData(){
        int size = DataSupport.findAll(Landscape.class).size();
        if (size == 0){
            Landscape landscape1 = new Landscape();
            landscape1.setImgId(1);
            landscape1.setIntroduce("长虹揽月，位于杭州电子科技大学正门，是学校标志性建筑，有亚洲首个最宽校门之称。高近30米，上书“杭州电子科技大学”几个大字，宽75米，如一道长虹擎起优美的弧线，将其侧月雅湖揽入怀中。学校前身为创建于1956年的杭州航空工业财经学校，“敢上九天揽月”的精神一直激励着杭电人坚守信念、脚踏实地，朝着梦想前进。万千师生由此而入，开启征程，走向未来。");
            landscape1.save();
            Landscape landscape2 = new Landscape();
            landscape2.setImgId(2);
            landscape2.setIntroduce("巨碟邀星，位于学校体育馆，是杭州市第二大体育馆。体育馆坚若磐石、恢弘大气，又因外型酷似飞碟，被学子们戏称为杭电“UFO”。这里不仅是学校各大体育赛事的承办地，更是开学典礼、毕业典礼、各大晚会及学科竞赛总决赛的见证地。作为曾经的万马篮球队的主场，这里还承办过第八届全国残疾人运动会轮椅篮球赛，《奔跑吧兄弟》第二季拍摄也在此进行。名人集聚，星光璀璨，熠熠生辉。该景点倡导学子“笃行之”。");
            landscape2.save();
            Landscape landscape3 = new Landscape();
            landscape3.setImgId(3);
            landscape3.setIntroduce("雅湖云影，位于学校东南角。月雅湖如一枚碧玉镶嵌于校门之旁，又似一位佳人依偎于大草坪之畔。周围有一雅廊点缀，一弯露台探入湖中，远观似在水一方。景名语出朱熹《观书有感》“半亩方塘一鉴开，天光云影共徘徊。问渠哪得清如许？为有源头活水来” ，以此鼓励学子心灵澄明，以开明宽阔的胸襟，接受鲜活的知识和思想。该景点倡导学子“明辨之”。");
            landscape3.save();
            Landscape landscape4 = new Landscape();
            landscape4.setImgId(4);
            landscape4.setIntroduce("书海风荷，位于校图书馆及其前方荷园，是校园十景中的盛夏之景。图书馆乃大学之重地，知识之殿堂。古云“小荷才露尖尖角”，勤学之子犹如初生之荷，在书海的映照下焕发勃勃生机。旖旎的池畔风荷与庄严的图书馆相互映照，清淡的荷香与高雅的书香相互氤氲。每逢六月，临别的毕业学子多在此留影，书馆、荷影、人面交相辉映，美不胜收，遂成一景。该景点倡导学子“博学之”。");
            landscape4.save();
            Landscape landscape5 = new Landscape();
            landscape5.setImgId(5);
            landscape5.setIntroduce("兰亭春晓，位于月雅湖畔西北角的花园。此亭乃仿文一校区“小兰亭”所建，寄托了杭电人对老校区的依依情怀。文一校区为全国四百家绿化先进单位，其中心花园，护土叠石，砌阶敷径，广种佳木，间植花卉，中有“士子苑”与“小兰亭”，各别点缀，多有蕴涵。此处虽弹丸之地，然落英缤纷，层绿绕园，曲径通幽，移步换景。学子在此间或咏或叙或思或憩，是为校园最幽处。");
            landscape5.save();
            Landscape landscape6 = new Landscape();
            landscape6.setImgId(6);
            landscape6.setIntroduce("艺苑秋歌，位于文化活动中心，为学校艺术荟萃之地，曾举办过第七届中国艺术节、大学生电影节，是“高雅艺术进校园”的演出基地。杭电素有原创音乐文化，培育了不少原创歌手，从摇滚巨星郑钧、音乐才子杨一、音乐小精灵陈悠悠到“中国最强音”刘瑞琦。这里孕育了1900原创影音工作室，已成为杭电原创艺术才子的“孵化器”。");
            landscape6.save();
            Landscape landscape7 = new Landscape();
            landscape7.setImgId(7);
            landscape7.setIntroduce("丛鱼听学，位于第十一教研楼与第十二教研楼之畔的东溪。溪中红鱼成群，自由嬉闹，惹人怜爱。东溪丛鱼在教学楼下听学已久，日夜熏陶，似有灵性。闲暇时，学子浅坐岸边，人鱼同乐，好不惬意。清华大学老校长梅贻琦先生曰“学校犹水也，师生犹鱼也，其行动犹游泳也，大鱼前导，小鱼尾随，是从游也。”该景点倡导学子“审问之”。");
            landscape7.save();
            Landscape landscape8 = new Landscape();
            landscape8.setImgId(8);
            landscape8.setIntroduce("三省问天，位于校园中轴线上的问天广场，乃学校正中心的大型雕塑。三根石柱擎天而立，柱身刻有各类象征符号，分别代表过去、现在和未来，上方有一圆轮连接三根石柱，象征时光的车轮滚滚向前，不断轮回。子曰“吾日三省吾身”，屈原亦有《天问》之作，于此处，思前贤，低头可躬身自问，仰头可探究苍穹。该景点倡导学子“慎思之”。");
            landscape8.save();
            Landscape landscape9 = new Landscape();
            landscape9.setImgId(9);
            landscape9.setIntroduce("藤廊寄梦，位于学生生活区“文一苑”的校友主题公园。廊长百余米，蜿蜒于宿舍楼下，上覆紫藤，每到春天，花开满廊，别有韵味，廊间镌刻校友寄语。杭电被誉为“中国IT企业家的摇篮”，知名校友企业有阿里巴巴集团、熊猫集团、海尔集团、长虹集团、海信集团、京东方集团等。校友们的励志寄语，激励着学子不断追求梦想，超越自我");
            landscape9.save();
            Landscape landscape10 = new Landscape();
            landscape10.setImgId(10);
            landscape10.setIntroduce("麦野浮金，位于学校体育场北侧麦园。学校素来倡导学子走出宿舍，奔向操场，增强体质，健康生活。多年来，杭电“阳光体育”运动走在全省前列，学校获教育部“阳光体育冬季长跑活动”先进单位称号。每年5、6月，麦子成熟的季节，金色饱满的麦粒散发出诱人的香甜，学子在体育场内挥洒汗水后，移步北侧，走入麦园，即可陶醉于熏风麦浪之中，拥抱大自然，感受丰收的喜悦。");
            landscape10.save();
        }
    }

}
