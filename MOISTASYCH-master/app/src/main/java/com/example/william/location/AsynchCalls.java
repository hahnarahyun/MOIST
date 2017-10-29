package com.example.william.location;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by William on 10/29/17.
 */

public class AsynchCalls extends AppCompatActivity {
    double medianHumidity, medianTemperature, medianPressure, waterTime;
    double a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asynchcalls);
        Button btn = (Button)findViewById(R.id.button);
        Button setB = (Button)findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FeedTask().execute();
            }
        });
        setB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txt = (TextView)findViewById(R.id.textView);
                txt.setText(String.valueOf(a));
            }
        });
    }


    public class FeedTask extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                OkHttpClient client = new OkHttpClient();
                //HttpURLConnection con = (HttpURLConnection)url.openConnection();
                //con.setRequestMethod("GET");
                //con.connect();

                //BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
                //String value = bf.readLine();
                //System.out.println("result is " + value);
                Request request = new Request.Builder()
                        .url("https://ic-event-service.run.aws-usw02-pr.ice.predix.io/v2/assets/ENV-ATL-0003-1/events?eventType=HUMIDITY&startTime=1508456827000&endTime=1508975227000")
                        .get()
                        .addHeader("authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImxlZ2FjeS10b2tlbi1rZXkiLCJ0eXAiOiJKV1QifQ.eyJqdGkiOiI2ZTFhYTRhMjlkYjA0OTRiYjBhNzZkOWM1Mzk5NjJhNyIsInN1YiI6ImhhY2thdGhvbiIsInNjb3BlIjpbInVhYS5yZXNvdXJjZSIsImllLWN1cnJlbnQuU0RTSU0tSUUtUFVCTElDLVNBRkVUWS5JRS1QVUJMSUMtU0FGRVRZLkxJTUlURUQuREVWRUxPUCIsImllLWN1cnJlbnQuU0RTSU0tSUUtRU5WSVJPTk1FTlRBTC5JRS1FTlZJUk9OTUVOVEFMLkxJTUlURUQuREVWRUxPUCIsImllLWN1cnJlbnQuU0RTSU0tSUUtVFJBRkZJQy5JRS1UUkFGRklDLkxJTUlURUQuREVWRUxPUCIsImllLWN1cnJlbnQuU0RTSU0tSUUtUEFSS0lORy5JRS1QQVJLSU5HLkxJTUlURUQuREVWRUxPUCIsImllLWN1cnJlbnQuU0RTSU0tSUUtUEVERVNUUklBTi5JRS1QRURFU1RSSUFOLkxJTUlURUQuREVWRUxPUCJdLCJjbGllbnRfaWQiOiJoYWNrYXRob24iLCJjaWQiOiJoYWNrYXRob24iLCJhenAiOiJoYWNrYXRob24iLCJncmFudF90eXBlIjoiY2xpZW50X2NyZWRlbnRpYWxzIiwicmV2X3NpZyI6IjlmMWYyYzRkIiwiaWF0IjoxNTA5MjE1MTU5LCJleHAiOjE1MDk4MTk5NTksImlzcyI6Imh0dHBzOi8vODkwNDA3ZDctZTYxNy00ZDcwLTk4NWYtMDE3OTJkNjkzMzg3LnByZWRpeC11YWEucnVuLmF3cy11c3cwMi1wci5pY2UucHJlZGl4LmlvL29hdXRoL3Rva2VuIiwiemlkIjoiODkwNDA3ZDctZTYxNy00ZDcwLTk4NWYtMDE3OTJkNjkzMzg3IiwiYXVkIjpbImllLWN1cnJlbnQuU0RTSU0tSUUtVFJBRkZJQy5JRS1UUkFGRklDLkxJTUlURUQiLCJpZS1jdXJyZW50LlNEU0lNLUlFLVBBUktJTkcuSUUtUEFSS0lORy5MSU1JVEVEIiwiaWUtY3VycmVudC5TRFNJTS1JRS1QVUJMSUMtU0FGRVRZLklFLVBVQkxJQy1TQUZFVFkuTElNSVRFRCIsInVhYSIsImhhY2thdGhvbiIsImllLWN1cnJlbnQuU0RTSU0tSUUtRU5WSVJPTk1FTlRBTC5JRS1FTlZJUk9OTUVOVEFMLkxJTUlURUQiLCJpZS1jdXJyZW50LlNEU0lNLUlFLVBFREVTVFJJQU4uSUUtUEVERVNUUklBTi5MSU1JVEVEIl19.POYOsGhHsp9d5BlUwn8tBTsZpQg7G3qfJgBBf9naXIw-9phGJ9HymbVf8T_g34MvMVTj24XICCNpX3-pc4ojcw2-PTyUn1L3pGg_2LVG48ov39RwLCEy4JqWDdsgrfpLiVoNVyCR1XB73zolIRCbNJXxjTP2arT3fvcSKLt0xl6mEJvtS3UNn2A9tgalcildVuT_9MxiRN3YIEwTOlpdQ2pc2FJYDblnv4DokdlpMSu8qq_govQSjKX19SeuNx9BBi-ukZVr8uRxJYJxbdMlOpyg_g-YH9Pkj_okKehMc8vurUPiLgK797PibgG9lLq0GGCwcUyYfhv9ACNITR7Cqg")
                        .addHeader("predix-zone-id", "SDSIM-IE-ENVIRONMENTAL")
                        .addHeader("cache-control", "no-cache")
                        .addHeader("postman-token", "a72b4423-95c8-966f-905d-6f4cb9dc0f56")
                        .build();
                Response response = client.newCall(request).execute();
                System.out.println(response.headers());
                System.out.println("this response" + response.body().toString());
                System.out.println(response.body());
//                System.out.println(response.body().string());
                String json = response.body().string();


                //JSONArray jsonArray = new JSONArray(jsonData);
                JSONObject jsonObject = new JSONObject(json.substring(json.indexOf("{"), json.lastIndexOf("}") + 1));
                medianHumidity = 0;
                System.out.println(jsonObject.getJSONArray("content"));
                JSONArray jsonArray = jsonObject.getJSONArray("content");
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject o = (JSONObject)jsonArray.get(i);
                    //JSONObject p = (JSONObject)o.get("measures");
                    //System.out.println(o.toString());
//                    //THISWORKS
//                    System.out.println(o.getString("measures"));
//                    System.out.println(o.get("locationUid"));
//                    System.out.println(o.get("assetUid"));
//                    System.out.println(o.get("timestamp"));
//                    System.out.println(o.get("eventType"));
                    JSONObject z = (JSONObject)o.get("measures");
                    //System.out.println(z.get("median"));
                    medianHumidity += (double)z.get("median");

//                    JSONArray a = (JSONArray)jsonArray.get(i);
//                    System.out.println(a.get(0));
                }
                System.out.println("median humidity : *****"+medianHumidity/jsonArray.length());
                //JSONObject firstObj = (JSONObject)jsonArray.get(0);
                //System.out.println(firstObj.getString("locationUid"));
                //System.out.println(firstObj.getString("assetUid"));

                Request request2 = new Request.Builder()
                        .url("https://ic-event-service.run.aws-usw02-pr.ice.predix.io/v2/assets/ENV-ATL-0003-1/events?eventType=TEMPERATURE&events%3FeventTypes=TEMPERATURE&events%3FeventTypes=HUMIDITY&startTime=1508456827000&endTime=1508975227000")
                        .get()
                        .addHeader("authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImxlZ2FjeS10b2tlbi1rZXkiLCJ0eXAiOiJKV1QifQ.eyJqdGkiOiI2ZTFhYTRhMjlkYjA0OTRiYjBhNzZkOWM1Mzk5NjJhNyIsInN1YiI6ImhhY2thdGhvbiIsInNjb3BlIjpbInVhYS5yZXNvdXJjZSIsImllLWN1cnJlbnQuU0RTSU0tSUUtUFVCTElDLVNBRkVUWS5JRS1QVUJMSUMtU0FGRVRZLkxJTUlURUQuREVWRUxPUCIsImllLWN1cnJlbnQuU0RTSU0tSUUtRU5WSVJPTk1FTlRBTC5JRS1FTlZJUk9OTUVOVEFMLkxJTUlURUQuREVWRUxPUCIsImllLWN1cnJlbnQuU0RTSU0tSUUtVFJBRkZJQy5JRS1UUkFGRklDLkxJTUlURUQuREVWRUxPUCIsImllLWN1cnJlbnQuU0RTSU0tSUUtUEFSS0lORy5JRS1QQVJLSU5HLkxJTUlURUQuREVWRUxPUCIsImllLWN1cnJlbnQuU0RTSU0tSUUtUEVERVNUUklBTi5JRS1QRURFU1RSSUFOLkxJTUlURUQuREVWRUxPUCJdLCJjbGllbnRfaWQiOiJoYWNrYXRob24iLCJjaWQiOiJoYWNrYXRob24iLCJhenAiOiJoYWNrYXRob24iLCJncmFudF90eXBlIjoiY2xpZW50X2NyZWRlbnRpYWxzIiwicmV2X3NpZyI6IjlmMWYyYzRkIiwiaWF0IjoxNTA5MjE1MTU5LCJleHAiOjE1MDk4MTk5NTksImlzcyI6Imh0dHBzOi8vODkwNDA3ZDctZTYxNy00ZDcwLTk4NWYtMDE3OTJkNjkzMzg3LnByZWRpeC11YWEucnVuLmF3cy11c3cwMi1wci5pY2UucHJlZGl4LmlvL29hdXRoL3Rva2VuIiwiemlkIjoiODkwNDA3ZDctZTYxNy00ZDcwLTk4NWYtMDE3OTJkNjkzMzg3IiwiYXVkIjpbImllLWN1cnJlbnQuU0RTSU0tSUUtVFJBRkZJQy5JRS1UUkFGRklDLkxJTUlURUQiLCJpZS1jdXJyZW50LlNEU0lNLUlFLVBBUktJTkcuSUUtUEFSS0lORy5MSU1JVEVEIiwiaWUtY3VycmVudC5TRFNJTS1JRS1QVUJMSUMtU0FGRVRZLklFLVBVQkxJQy1TQUZFVFkuTElNSVRFRCIsInVhYSIsImhhY2thdGhvbiIsImllLWN1cnJlbnQuU0RTSU0tSUUtRU5WSVJPTk1FTlRBTC5JRS1FTlZJUk9OTUVOVEFMLkxJTUlURUQiLCJpZS1jdXJyZW50LlNEU0lNLUlFLVBFREVTVFJJQU4uSUUtUEVERVNUUklBTi5MSU1JVEVEIl19.POYOsGhHsp9d5BlUwn8tBTsZpQg7G3qfJgBBf9naXIw-9phGJ9HymbVf8T_g34MvMVTj24XICCNpX3-pc4ojcw2-PTyUn1L3pGg_2LVG48ov39RwLCEy4JqWDdsgrfpLiVoNVyCR1XB73zolIRCbNJXxjTP2arT3fvcSKLt0xl6mEJvtS3UNn2A9tgalcildVuT_9MxiRN3YIEwTOlpdQ2pc2FJYDblnv4DokdlpMSu8qq_govQSjKX19SeuNx9BBi-ukZVr8uRxJYJxbdMlOpyg_g-YH9Pkj_okKehMc8vurUPiLgK797PibgG9lLq0GGCwcUyYfhv9ACNITR7Cqg")
                        .addHeader("predix-zone-id", "SDSIM-IE-ENVIRONMENTAL")
                        .addHeader("cache-control", "no-cache")
                        .addHeader("postman-token", "76f8e934-6593-2dff-b715-e75483a2b717")
                        .build();

                Response response2 = client.newCall(request2).execute();
                String json2 = response2.body().string();
                JSONObject jsonObject2 = new JSONObject(json2.substring(json2.indexOf("{"), json2.lastIndexOf("}") + 1));

                JSONArray jsonArray2 = jsonObject2.getJSONArray("content");
                for(int i = 0; i < jsonArray2.length(); i++){
                    JSONObject o = (JSONObject) jsonArray2.get(i);
                    JSONObject z = (JSONObject) o.get("measures");
                    medianTemperature += (double) z.get("median");
                }
                medianTemperature = medianTemperature/jsonArray2.length();
                System.out.println("Median Temp************"+ medianTemperature);


                Request request3 = new Request.Builder()
                        .url("https://ic-event-service.run.aws-usw02-pr.ice.predix.io/v2/assets/ENV-ATL-0003-1/events?eventType=PRESSURE&events%3FeventTypes=TEMPERATURE&events%3FeventTypes=HUMIDITY&startTime=1508456827000&endTime=1508975227000")
                        .get()
                        .addHeader("authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImxlZ2FjeS10b2tlbi1rZXkiLCJ0eXAiOiJKV1QifQ.eyJqdGkiOiI2ZTFhYTRhMjlkYjA0OTRiYjBhNzZkOWM1Mzk5NjJhNyIsInN1YiI6ImhhY2thdGhvbiIsInNjb3BlIjpbInVhYS5yZXNvdXJjZSIsImllLWN1cnJlbnQuU0RTSU0tSUUtUFVCTElDLVNBRkVUWS5JRS1QVUJMSUMtU0FGRVRZLkxJTUlURUQuREVWRUxPUCIsImllLWN1cnJlbnQuU0RTSU0tSUUtRU5WSVJPTk1FTlRBTC5JRS1FTlZJUk9OTUVOVEFMLkxJTUlURUQuREVWRUxPUCIsImllLWN1cnJlbnQuU0RTSU0tSUUtVFJBRkZJQy5JRS1UUkFGRklDLkxJTUlURUQuREVWRUxPUCIsImllLWN1cnJlbnQuU0RTSU0tSUUtUEFSS0lORy5JRS1QQVJLSU5HLkxJTUlURUQuREVWRUxPUCIsImllLWN1cnJlbnQuU0RTSU0tSUUtUEVERVNUUklBTi5JRS1QRURFU1RSSUFOLkxJTUlURUQuREVWRUxPUCJdLCJjbGllbnRfaWQiOiJoYWNrYXRob24iLCJjaWQiOiJoYWNrYXRob24iLCJhenAiOiJoYWNrYXRob24iLCJncmFudF90eXBlIjoiY2xpZW50X2NyZWRlbnRpYWxzIiwicmV2X3NpZyI6IjlmMWYyYzRkIiwiaWF0IjoxNTA5MjE1MTU5LCJleHAiOjE1MDk4MTk5NTksImlzcyI6Imh0dHBzOi8vODkwNDA3ZDctZTYxNy00ZDcwLTk4NWYtMDE3OTJkNjkzMzg3LnByZWRpeC11YWEucnVuLmF3cy11c3cwMi1wci5pY2UucHJlZGl4LmlvL29hdXRoL3Rva2VuIiwiemlkIjoiODkwNDA3ZDctZTYxNy00ZDcwLTk4NWYtMDE3OTJkNjkzMzg3IiwiYXVkIjpbImllLWN1cnJlbnQuU0RTSU0tSUUtVFJBRkZJQy5JRS1UUkFGRklDLkxJTUlURUQiLCJpZS1jdXJyZW50LlNEU0lNLUlFLVBBUktJTkcuSUUtUEFSS0lORy5MSU1JVEVEIiwiaWUtY3VycmVudC5TRFNJTS1JRS1QVUJMSUMtU0FGRVRZLklFLVBVQkxJQy1TQUZFVFkuTElNSVRFRCIsInVhYSIsImhhY2thdGhvbiIsImllLWN1cnJlbnQuU0RTSU0tSUUtRU5WSVJPTk1FTlRBTC5JRS1FTlZJUk9OTUVOVEFMLkxJTUlURUQiLCJpZS1jdXJyZW50LlNEU0lNLUlFLVBFREVTVFJJQU4uSUUtUEVERVNUUklBTi5MSU1JVEVEIl19.POYOsGhHsp9d5BlUwn8tBTsZpQg7G3qfJgBBf9naXIw-9phGJ9HymbVf8T_g34MvMVTj24XICCNpX3-pc4ojcw2-PTyUn1L3pGg_2LVG48ov39RwLCEy4JqWDdsgrfpLiVoNVyCR1XB73zolIRCbNJXxjTP2arT3fvcSKLt0xl6mEJvtS3UNn2A9tgalcildVuT_9MxiRN3YIEwTOlpdQ2pc2FJYDblnv4DokdlpMSu8qq_govQSjKX19SeuNx9BBi-ukZVr8uRxJYJxbdMlOpyg_g-YH9Pkj_okKehMc8vurUPiLgK797PibgG9lLq0GGCwcUyYfhv9ACNITR7Cqg")
                        .addHeader("predix-zone-id", "SDSIM-IE-ENVIRONMENTAL")
                        .addHeader("cache-control", "no-cache")
                        .addHeader("postman-token", "47cd17ad-b3e2-e889-0c0c-abe8eb51c613")
                        .build();

                Response response3 = client.newCall(request3).execute();
                String json3 = response3.body().string();
                JSONObject jsonObject3 = new JSONObject(json3.substring(json3.indexOf("{"), json3.lastIndexOf("}") + 1));

                JSONArray jsonArray3 = jsonObject3.getJSONArray("content");
                for(int i = 0; i < jsonArray3.length(); i++){
                    JSONObject o = (JSONObject) jsonArray3.get(i);
                    JSONObject z = (JSONObject) o.get("measures");
                    medianTemperature += (double) z.get("median");
                }
                medianPressure = medianTemperature/jsonArray3.length();
                System.out.println("Median Pressure************"+ medianPressure);
                medianTemperature = 2710;
                a = (0.25817 * (0.1427 * medianHumidity + 157 ) * (medianTemperature / medianPressure) - 157)/10000000;
            } catch (Exception e) {
                System.out.println(e);
            }
            return null;
        }
    }
}
