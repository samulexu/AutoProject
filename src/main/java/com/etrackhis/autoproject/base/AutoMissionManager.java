package com.etrackhis.autoproject.base;

import com.etrack.common.core.utils.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Component
@Scope("singleton")
public class AutoMissionManager {
    private Map<String, Boolean> missionState;

    {
        missionState = new ConcurrentHashMap<>();
    }
    public boolean containMission(String missionId){
        return missionState.containsKey(missionId);
    }
    public boolean getState(String missionId){
        String res = MapUtils.getString(missionState,missionId,"");
        if (StringUtils.isEmpty(res) || res.equals("false")){
            return false;
        }else{
            return true;
        }
    }

    public void setState(String missionId,boolean state){
        this.missionState.put(missionId, state);
    }

    public void removeState(String missionId){
        this.missionState.remove(missionId);
    }
    public void clear(){
        this.missionState.clear();
    }
}
