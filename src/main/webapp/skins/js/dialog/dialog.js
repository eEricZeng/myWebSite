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

/** 发送点击事件*/
function sendQuestion(){
    var question = $('#input-text').val();
    $('#input-text').val('');
    $('#input-text').focus();
    send(question);
    var context = getContextPath();
    $.ajax({
        url: context + "/service/dialog/bot/single",
        type: "POST",
        contentType: "application/json;charset=UTF-8",
        data: JSON.stringify({
            "question": question
        }),
        dataType: "json",
        success:function(data){
            if(data.success=="true"){
                var response = data.response;
                var answers = response.results;
                for(var i in answers){
                    switch(answers[i].resultType){
                        case "text":
                            show(answers[i].values);break;
                        case "image":// TODO 完成非文本类型答案展示
                            show(answers[i].values);break;
                        case "url":
                            show(answers[i].values);break;
                        case "voice":
                            break;
                        case "video":
                            break;
                        case "news":
                            break;
                    }
                }
            }else if(data.success=="false"){
                show({text:"我不知道你在说啥。。。"});
            }
        }
    });
}

var showAnswer = {}

/** 输入内容监听 */
function listenInput(event) {
    if (event.keyCode == 13) {
        $('#send-message').trigger('click');
    }
}

/** 发送消息 */
function send(message) {
    var html = template("question-template", {
        "type" : "answer",
        "time" : timeListen(),
        "message" : message
    });
    upView(html);
}
/** 机器人消息 */
function show(valObj) {
    var html = template("robot-template", {
        "type" : "question",
        "time" : timeListen(),
        "robotName": "robot1",
        "message" : valObj.text,
        "url": valObj.url,
        "image": valObj.image
    });
    upView(html);
}

var lastTime = 0;
/** 时间监控，超过1分钟未回复则打印时间*/
function timeListen(){
    var currentTime = new Date();
    var time="";
    if(0==lastTime||currentTime-lastTime>60000){
        time = timeFormat(currentTime,'yyyy-MM-dd hh:mm');
    }
    lastTime = currentTime;
    return time;
}
/** 时间格式化*/
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
/** 调整滚动条*/
function upView(html) {
    $('.speak_box').append(html);
    var speak_height = $('.speak_box').height();
    $('.speak_box,.speak_window').animate({
        scrollTop : speak_height
    }, 500);
}
/** 调整对话宽度*/
function autoWidth() {
    $('.question_text').css('max-width', $('.question').width() - 60);
}
autoWidth();