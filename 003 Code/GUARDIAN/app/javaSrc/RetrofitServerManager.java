package com.mcuhq.simplebluetooth2;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitServerManager {

    private static final String BASE_URL = "http://121.152.22.85:40080/"; // Real Address

    private static RetrofitService apiService;

    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(300, TimeUnit.SECONDS)
            .writeTimeout(300, TimeUnit.SECONDS)
            .readTimeout(300, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build();

    private void initializeApiService() {
        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiService = retrofit.create(RetrofitService.class);
        }
    }

    public interface APICallback<T> {
        void onSuccess(T result);
        void onFailure(Exception e);
    }

    public interface ServerTaskCallback {
        void onSuccess(String result);
        void onFailure(Exception e);
    }

    public interface UserDataCallback {
        void userData(UserProfile userProfile);
        void onFailure(Exception e);
    }

    public interface HourlyDataCallback {
        void hourlyData(List data);
        void onFailure(Exception e);
    }

    public interface DataCallback {
        void getData(List<Map<String, String>> data);
        void onFailure(Exception e);
    }

    public interface ArrDataCallback {
        void getData(List<String> dataList);
        void onFailure(Exception e);
    }

    public interface RealBpmCallback {
        void getBpm(String bpm);
        void onFailure(Exception e);
    }


    public void loginTask(String email, String pw, String phone, String token, ServerTaskCallback callback) {

        try {

            Map<String, Object> mapParam = new HashMap<>();
            mapParam.put("eq", email);
            mapParam.put("password", pw);
            mapParam.put("phone", phone);

            // API 호출
            loginTaskFromAPI(mapParam, callback);

        } catch (Exception e) {
            callback.onFailure(e);
        }
    }

    public void loginTaskFromAPI(Map<String, Object> loginData, ServerTaskCallback callback) {

        initializeApiService();

        Call<String> call = apiService.checkLogin(loginData.get("eq").toString(), loginData.get("password").toString(), loginData.get("phone").toString());

        executeCall(call, new APICallback<String>() {
            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result);
            }

            @Override
            public void onFailure(Exception e) {
                callback.onFailure(e);
            }
        });
    }

    public void tokenTask(String email, String pw, String phone, String token, ServerTaskCallback callback) {

        try {

            Map<String, Object> mapParam = new HashMap<>();
            mapParam.put("eq", email);
            mapParam.put("password", pw);
            mapParam.put("phone", phone);
            mapParam.put("token", token);

            // API 호출
            tokenTaskFromAPI(mapParam, callback);

        } catch (Exception e) {
            callback.onFailure(e);
        }
    }

    public void tokenTaskFromAPI(Map<String, Object> loginData, ServerTaskCallback callback) {

        initializeApiService();

        Call<String> call = apiService.setToken(loginData.get("eq").toString(), loginData.get("password").toString(), loginData.get("phone").toString(), loginData.get("token").toString());

        executeCall(call, new APICallback<String>() {
            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result);
            }

            @Override
            public void onFailure(Exception e) {
                callback.onFailure(e);
            }
        });
    }


    public void getProfile(String email, UserDataCallback callback) {

        try {
            Map<String, Object> mapParam = new HashMap<>();
            mapParam.put("eq", email);

            // API 호출
            getProfileFromAPI(mapParam, callback);

        } catch (Exception e) {
            callback.onFailure(e);
        }
    }



    public void getProfileFromAPI(Map<String, Object> mapParam, UserDataCallback callback) {

        initializeApiService();

        Call<List<UserProfile>> call = apiService.getProfileData(mapParam.get("eq").toString());

        executeCall(call, new APICallback<List<UserProfile>>() {
            @Override
            public void onSuccess(List<UserProfile> result) {
                Log.e("getProfileFromAPI", String.valueOf(result.size()));

                try {
                    if (!result.isEmpty()) {
                        UserProfile profile = result.get(0);
//                        UserProfile profile2 = result.get(1);

//                        Log.e("profile1", "profile1");
//                        Log.e("getGender", profile.getGender());
//                        Log.e("getBirthday", profile.getBirthday());
//                        Log.e("getAge", profile.getAge());
//                        Log.e("getName", profile.getName());
//                        Log.e("getPhone", profile.getPhone());
//                        Log.e("getWeight", profile.getWeight());
//                        Log.e("getHeight", profile.getHeight());
//                        Log.e("getSleepStart", profile.getSleepStart());
//                        Log.e("getSleepEnd", profile.getSleepEnd());
//                        Log.e("getJoinDate", profile.getJoinDate());
//                        Log.e("getDailyCalorie", profile.getDailyCalorie());
//                        Log.e("getDailyActivityCalorie", profile.getDailyActivityCalorie());
//                        Log.e("getDailyStep", profile.getDailyStep());
//                        Log.e("getDailyDistance", profile.getDailyDistance());
//                        Log.e("getGuardian", profile.getGuardian());
//
//                        Log.e("profile2", "profile2");
//                        Log.e("getGender", profile2.getGender());
//                        Log.e("getBirthday", profile2.getBirthday());
//                        Log.e("getAge", profile2.getAge());
//                        Log.e("getName", profile2.getName());
//                        Log.e("getPhone", profile2.getPhone());
//                        Log.e("getWeight", profile2.getWeight());
//                        Log.e("getHeight", profile2.getHeight());
//                        Log.e("getSleepStart", profile2.getSleepStart());
//                        Log.e("getSleepEnd", profile2.getSleepEnd());
//                        Log.e("getJoinDate", profile2.getJoinDate());
//                        Log.e("getDailyCalorie", profile2.getDailyCalorie());
//                        Log.e("getDailyActivityCalorie", profile2.getDailyActivityCalorie());
//                        Log.e("getDailyStep", profile2.getDailyStep());
//                        Log.e("getDailyDistance", profile2.getDailyDistance());
//                        Log.e("getGuardian", profile2.getGuardian());

                        callback.userData(profile);  // 콜백 호출
                    }
                }catch (Exception ignored) {
                    callback.onFailure(ignored);
                }
            }

            @Override
            public void onFailure(Exception e) {
                callback.onFailure(e);
            }
        });
    }




    public void getReaBPM(String email, RealBpmCallback callback) {

        try {
            Map<String, Object> mapParam = new HashMap<>();
            mapParam.put("eq", email);

            // API 호출
            getRealBPMFromAPI(mapParam, callback);

        } catch (Exception e) {
            callback.onFailure(e);
        }
    }

    public void getRealBPMFromAPI(Map<String, Object> mapParam, RealBpmCallback callback) {

        initializeApiService();

        Call<String> call = apiService.getRealBPM(mapParam.get("eq").toString());

        executeCall(call, new APICallback<String>() {
            @Override
            public void onSuccess(String result) {
                callback.getBpm(result);
            }

            @Override
            public void onFailure(Exception e) {
                callback.onFailure(e);
            }
        });
    }









    public void getBpmData(String kind, String email, String startDate, String endDate, DataCallback callback) {
        try {
            Map<String, Object> mapParam = new HashMap<>();
            mapParam.put("kind", kind);
            mapParam.put("eq", email);
            mapParam.put("startDate", startDate);
            mapParam.put("endDate", endDate);

            // API 호출
            getBPMDataFromAPI(mapParam, callback);

        } catch (Exception e) {
            callback.onFailure(e);
        }
    }

    public void getBPMDataFromAPI(Map<String, Object> mapParam, DataCallback callback) {

        initializeApiService();

        Call<String> call = apiService.getBpmData(
                mapParam.get("eq").toString(),
                mapParam.get("startDate").toString(),
                mapParam.get("endDate").toString()
        );

        executeCall(call, new APICallback<String>() {
            @Override
            public void onSuccess(String result) {
                String[] lines = result.split("\n");
                List<Map<String, String>> dataList = new ArrayList<>();

                for (String line : lines) {
                    String[] segments = line.split("\\|"); // 파이프(|) 구분

                    if (segments.length >= 6) {
                        Map<String, String> data = new HashMap<>();

                        data.put("email", segments[1]);
                        data.put("time", segments[2]);
                        data.put("utcOffset", segments[3]);
                        data.put("bpm", segments[4]);
                        data.put("temp", segments[5]);
                        data.put("hrv", segments[6]);

                        dataList.add(data);

                    }
                }
                callback.getData(dataList);
            }

            @Override
            public void onFailure(Exception e) {
                callback.onFailure(e);
            }
        });
    }










    public void getHourlyData(String kind, String email, String startDate, String endDate, HourlyDataCallback callback) {

        try {
            Map<String, Object> mapParam = new HashMap<>();
            mapParam.put("kind", kind);
            mapParam.put("eq", email);
            mapParam.put("startDate", startDate);
            mapParam.put("endDate", endDate);

            // API 호출
            getHourlyDataFromAPI(mapParam, callback);

        } catch (Exception e) {
            callback.onFailure(e);
        }

    }

    public void getHourlyDataFromAPI(Map<String, Object> mapParam, HourlyDataCallback callback) {

        initializeApiService();

        Call<String> call = apiService.getHourlyData(
                mapParam.get("eq").toString(),
                mapParam.get("startDate").toString(),
                mapParam.get("endDate").toString()
        );

        executeCall(call, new APICallback<String>() {
            @Override
            public void onSuccess(String result) {
                String[] lines = result.split("\n");
                List<String> dataList = new ArrayList<>();

                for (String line : lines) {
                    String[] segments = line.split("\\|"); // 파이프(|) 구분
                    if (segments.length > 11 && !segments[5].equals("datahour")) {
                        dataList.add(segments[1] + "," + segments[2] + "," + segments[6] + "," + segments[7]+ "," + segments[8]+ "," + segments[9]+ "," + segments[10]+ "," + segments[11]);
                    }
                }
                callback.hourlyData(dataList); // 콜백 호출
            }

            @Override
            public void onFailure(Exception e) {
                callback.onFailure(e);
            }
        });
    }











    public void getArrData(String kind, String idx, String email, String startDate, String endDate, ArrDataCallback callback)  {

        try {

            Map<String, Object> mapParam = new HashMap<>();
            mapParam.put("kind", kind);
            mapParam.put("idx", idx);
            mapParam.put("eq", email);
            mapParam.put("startDate", startDate);
            mapParam.put("endDate", endDate);

            // API 호출
            getArrDataFromAPI(mapParam, callback);

        } catch (Exception e) {
            callback.onFailure(e);  // 콜백 호출
        }
    }

    public void getArrDataFromAPI(Map<String, Object> mapParam, ArrDataCallback callback) {

        initializeApiService();

        Call<String> call = apiService.getArrData(
                mapParam.get("idx").toString(),
                mapParam.get("eq").toString(),
                mapParam.get("startDate").toString(),
                mapParam.get("endDate").toString()
        );

        executeCall(call, new APICallback<String>() {
            @Override
            public void onSuccess(String result) {
                String[] lines = result.split("\n");
                List<String> dataList = new ArrayList<>();
                for (String line : lines) {
                    if ( line.length() > 3 ) {
//                        Log.e("line", line);
                        if ( !line.contains("|null"))
                            dataList.add(line);
                    }
                }
                callback.getData(dataList);
            }

            @Override
            public void onFailure(Exception e) {
                callback.onFailure(e);
            }
        });
    }


    private <T> void executeCall(Call<T> call, APICallback<T> callback) {
        call.enqueue(new retrofit2.Callback<T>() {
            @Override
            public void onResponse(Call<T> call, retrofit2.Response<T> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure(new Exception("API call not successful"));
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                callback.onFailure(new Exception(t));
            }
        });
    }
}