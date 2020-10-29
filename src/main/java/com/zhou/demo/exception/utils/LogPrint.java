package com.zhou.demo.exception.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

/**
 * @ClassName LogPrint
 * @Author JackZhou
 * @Date 2020/10/26  16:59
 **/

@Slf4j
@Component
public class LogPrint {

    private static boolean flag = false;

    public static void setFlag(boolean flag) {
        LogPrint.flag = flag;
    }

    @PostConstruct
    public void init() {
        CompletableFuture.runAsync(() -> printLog(), Executors.newSingleThreadExecutor());
    }

    public void printLog(){
        while(true){
            if(flag){
                log.info(" 豫章故郡，洪都新府。星分翼轸(zhěn)，地接衡庐。襟三江而带五湖，控蛮荆而引瓯（ōu）越。物华天宝，龙光射牛斗之墟；人杰地灵，徐孺下陈蕃(fān)之榻。雄州雾列，俊采星驰，台隍(huáng)枕夷夏之交，宾主尽东南之美。都督阎公之雅望，棨(qǐ )戟遥临；宇文新州之懿(yì)范，襜(chān )帷(wéi)暂驻。十旬休假，胜友如云；千里逢迎，高朋满座。腾蛟起凤，孟学士之词宗；紫电清霜，王将军之武库。家君作宰，路出名区；童子何知，躬逢胜饯。\n" + "　　时维九月，序属三秋。潦（lǎo）水尽而寒潭清，烟光凝而暮山紫。俨(yǎn)骖騑(cān fēi)于上路，访风景于崇阿(ē)。临帝子之长洲，得天人之旧馆。层峦耸翠，上出重霄；飞阁流（一作 翔）丹，下临无地。鹤汀（tīng）凫(fú )渚（zhǔ），穷岛屿之萦(yíng)回；桂殿兰宫，即（一作 列）冈峦之体势。\n" + "　　披绣闼（tà），俯雕甍(méng )。山原旷其盈视，川泽纡(yū)其骇瞩。闾(lǘ)阎(yán) 扑地，钟鸣鼎食之家；舸（gě)舰弥津，青雀黄龙之舳（zhú）。云销雨霁(jì)，彩彻区明（或作 虹销雨霁，彩彻云衢 qú）。落霞与孤鹜(wù)齐飞，秋水共长天一色。渔舟唱晚，响穷彭蠡（l ǐ）之滨；雁阵惊寒，声断衡阳之浦。\n" + "　　遥襟甫畅，逸兴遄(chuán)飞。爽籁发而清风生，纤歌凝而白云遏(è)。睢(suī)园绿竹，气凌彭泽之樽；邺(yè)水朱华，光照临川之笔。四美具，二难并。穷睇眄(dì miǎn)于中天，极娱游于暇日。天高地迥(jiǒng)，觉宇宙之无穷；兴尽悲来，识盈虚之有数。望长安于日下，目吴会（kuài）于云间。地势极而南溟(míng)深，天柱高而北辰远。关山难越，谁悲失路之人；萍水相逢，尽是他乡之客。怀帝阍(hūn)而不见，奉宣室以何年。\n" + "　　嗟(jiē)乎！时运不齐，命途多舛(chuǎn)；冯唐易老，李广难封。屈贾谊（yì）于长沙，非无圣主；窜梁鸿于海曲，岂乏明时？所赖君子见机，达人知命。老当益壮，宁移白首之心？穷且益坚，不坠青云之志。酌贪泉而觉爽，处涸辙（hé zhé）以犹欢。北海虽赊（shē），扶摇可接；东隅(yú)已逝，桑榆非晚。孟尝高洁，空余报国之情；阮籍猖狂，岂效穷途之哭！\n" + "　　勃，三尺微命，一介书生。无路请缨，等终军之弱冠（guàn）；有怀投笔，慕宗悫（què）之长风。舍簪（zān）笏（hù）于百龄，奉晨昏于万里。非谢家之宝树，接孟氏之芳邻。他日趋庭，叨(tāo)陪鲤对；今兹捧袂(mèi)，喜托龙门。杨意不逢，抚凌云而自惜；钟期既遇，奏流水以何惭？\n" + "　　呜呼！胜地不常，盛筵(yán)难再；兰亭已矣，梓(zǐ) 泽丘墟。临别赠言，幸承恩于伟饯；登高作赋，是所望于群公。敢竭鄙怀，恭疏短引；一言均赋，四韵俱成。请洒潘江，各倾陆海云尔。　\n" + "　　滕王高阁临江渚，佩玉鸣鸾罢歌舞。\n" + "　　画栋朝飞南浦云，珠帘暮卷西山雨。\n" + "　　闲云潭影日悠悠，物换星移几度秋。\n" + "　　阁中帝子今何在？槛外长江空自流");
            }
        }
    }

}
