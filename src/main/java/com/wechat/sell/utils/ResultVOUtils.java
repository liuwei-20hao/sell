package com.wechat.sell.utils;

import com.wechat.sell.VO.ResultVO;

public class ResultVOUtils {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("success");
        return  resultVO;
    }

    public static ResultVO success(){
        return  success(null);
    }

    public static ResultVO error(Integer Code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(Code);
        resultVO.setMsg(msg);
        return  resultVO;
    }
}
