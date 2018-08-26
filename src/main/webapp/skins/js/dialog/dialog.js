$(function() {
    // 绑定事件
    initAllEvent();
})

function initAllEvent() {
    // 输入内容监听
    $(document).on('keyup', '#input-text', listenInput);
    // 发送点击事件
    $(document).on('click', '#send-message', sendQuestion);
}

/*发送点击事件*/
function sendQuestion(){
    var message = $('#input-text').val();
    $('#input-text').val('');
    $('#input-text').focus();
    send(message);
    var context = getContextPath();
    $.ajax({
        url: context + "/service/dialog/bot/single",
        type: "POST",
        contentType: "application/json;charset=UTF-8",
        data: JSON.stringify({
            "message": message
        }),
        dataType: "json",
        success:function(data){
            
        }
    });
//    autoWidth();
//    upView();
}

/* 输入内容监听 */
function listenInput(event) {
    if (event.keyCode == 13) {
        $('#send-message').trigger('click');
    }
}

/* 发送消息 */
function send(message) {
    var html = template("question-template", {
        "type" : "answer",
        "time" : timeListen(),
        "message" : message
    });
    upView(html);
}
/* 接受消息 */
function show(message) {
    var html = template("robot-template", {
        "type" : "question",
        "time" : timeListen(),
        "robotName": "robot1",
        "message" : message
    });
    upView(html);
}

var lastTime = 0;
/**时间监控，超过1分钟未回复则打印时间*/
function timeListen(){
    var currentTime = new Date();
    var time="";
    if(0==lastTime||currentTime-lastTime>60000){
        time = timeFormat(currentTime,'yyyy-MM-dd hh:mm');
    }
    lastTime = currentTime;
    return time;
}

function timeFormat(date, format) {  
    
    date = new Date(date);  

    var map = {  
        "M": date.getMonth() + 1, //月份   
        "d": date.getDate(), //日   
        "h": date.getHours(), //小时   
        "m": date.getMinutes(), //分   
        "s": date.getSeconds(), //秒   
        "q": Math.floor((date.getMonth() + 3) / 3), //季度   
        "S": date.getMilliseconds() //毫秒   
    };  
    format = format.replace(/([yMdhmsqS])+/g, function (all, t) {  
        var v = map[t];  
        if (v !== undefined) {  
            if (all.length > 1) {  
                v = '0' + v;  
                v = v.substr(v.length - 2);  
            }  
            return v;  
        } else if (t === 'y') {  
            return (date.getFullYear() + '').substr(4 - all.length);  
        }  
        return all;  
    });  
    return format;  
}

//template日期格式化
/*template.helper('dateFormat', function(date, format) {  
    
    date = new Date(date);  

    var map = {  
        "M": date.getMonth() + 1, //月份   
        "d": date.getDate(), //日   
        "h": date.getHours(), //小时   
        "m": date.getMinutes(), //分   
        "s": date.getSeconds(), //秒   
        "q": Math.floor((date.getMonth() + 3) / 3), //季度   
        "S": date.getMilliseconds() //毫秒   
    };  
    format = format.replace(/([yMdhmsqS])+/g, function (all, t) {  
        var v = map[t];  
        if (v !== undefined) {  
            if (all.length > 1) {  
                v = '0' + v;  
                v = v.substr(v.length - 2);  
            }  
            return v;  
        } else if (t === 'y') {  
            return (date.getFullYear() + '').substr(4 - all.length);  
        }  
        return all;  
    });  
    return format;  
});*/

var Bene = [
        '你终于来啦，我找你N年了，去火星干什么了？我现在去冥王星，回头跟你说个事，别走开啊！',
        '有事找我请大叫！',
        '你要和我说话？你真的要和我说话？你确定自己想说吗？你一定非说不可吗？那你说吧，这是自动回复，反正我看不见',
        '起床时想到你的微笑，洗脸时嗅到你的味道，上床前你是我的需要。真的不能离开你，我亲爱的??马桶',
        '嘿，我知道一个能让我在走路的时候不被绷带绊倒的办法，你们想听么？',
        '帅有个屁用！到头来还不是被卒吃掉！',
        '如果你看到面前的阴影，别怕，那是因为你的背后有阳光。',
        '付出就要赢得回报，这是永恒的真理，自古以来很少有人能突破它。然而，如果有人能够超越它的限制，付出而不求回报，那么他一定会得到得更多。',
        '从前有个怪物，他一直在吃东西，却怎么也吃不饱。所以到最后，他把他自己也吃掉了！ ',
        '如果你受苦了，感谢生活，那是它给你的一份感觉；如果你受苦了，感谢上帝，说明你还活着。人们的灾祸往往成为他们的学问。',
        '本人纯属虚构，如遇在线，实属见鬼！',
        '就算你是一支狗尾巴草，也要把自己包装成一支有特色又有气质的狗尾巴草，合作的时候先夸大，之后再做实事。记住，你就是一支特立独行又优雅的狗尾巴草，千万别把自己说成玫瑰”。',
        '我觉得最大的歧视就是怜悯，比如一个残疾的人或者生活很不幸的人，你对他越怜悯，这是对他最大的歧视，其实我们从来不怜悯悲伤，而是带着悲伤一块玩。',
        '我的人生有A面也有B面，你的人生有S面也有B面。',
        '生活有时就像被太监强奸一样??反抗是痛苦，不反抗还是痛苦！',
        '我也是从石头里蹦出来的，为什么我不是猴子呢？',
        '令我感到骄傲和自豪的是，至今为止，地球仍被我踩在脚下。 ',
        '物价涨得太快，所以我在餐馆吃饭的时候都会先付钱。',
        '以解决自己的问题为目标，这是一个实实在在的道理，正视自己的问题，设法解决它，这是成功的捷径。谁能塌下心来把目光凝集在一个个小漏洞、小障碍上，谁就先迈出了一大步。',
        '真的要跟我聊天？想好了？不后悔了？真的不后悔了？', '一个男人的价值，可以从他胡子的长度，以及……皮带的长度上看出来',
        '如果1分钟内没答复，那么我在小便；如果5分钟内没答复，那么我在大便；如果30分钟内没答复，那么我没带纸。',
        '你的眼睛眨一下，我就死去，你的眼睛再眨一下，我就活过来，你的眼睛不停地眨来眨去，于是我便死去活来！',
        '你怎么点到这里来了啊！你点到鬼门关了还不快下线要不我都救不了你了，回去洗个澡烧柱香还能活三十年！',
        '欠我的钱你什么时候还啊~~不还别吵我~~', '很多人都说我是吸血鬼，但你看，其实我并不讨厌阳光，相反，我还经常在白天打架呢！',
        '本人现在位置：WC，姿势：下蹲 脸部：抽搐 状态：用力中。。。。 ', '本机已调成震动 ,小心说话 ,我机子子震坏了 ,看我扁你不！',
        '你好.我去叫几个人,很快回来 。', '单身的典型标志就是一个月流量套餐早没了，通话套餐还剩一大半。' ]

function up_say() {
    var text = $('.write_box input').val(), str = '<div class="question">';
    str += '<div class="heard_img right"><img src="../../skins/skin/dialog/img/visitor.jpg"/></div>';
    str += '<div class="question_text clear"><p>' + text + '</p>';
    str += '</div></div>';

    if (text == '') {
        alert('请输入提问！');
        $('.write_box input').focus();
    } else {
        $('.speak_box').append(str);
        $('.write_box input').val('');
        // $('.write_box input').focus();
        $(".write_box input").blur();
        autoWidth();
        upView();
        setTimeout(
                function() {
                    var Benelen = Math.floor(Math.random() * 29);
                    var ans = '<div class="answer"><div class="heard_img left"><img src="../../skins/skin/dialog/img/robot1.jpg"/></div>';
                    ans += '<div class="answer_text"><p>' + Bene[Benelen]
                            + '</p>';
                    ans += '</div></div>';
                    $('.speak_box').append(ans);
                    upView();
                }, 1000);
    }
}

function upView(html) {
    $('.speak_box').append(html);
    var speak_height = $('.speak_box').height();
    $('.speak_box,.speak_window').animate({
        scrollTop : speak_height
    }, 500);
}

function autoWidth() {
    $('.question_text').css('max-width', $('.question').width() - 60);
}
autoWidth();