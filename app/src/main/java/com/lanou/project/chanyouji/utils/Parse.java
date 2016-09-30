package com.lanou.project.chanyouji.utils;

import com.lanou.project.chanyouji.Class.Node;
import com.lanou.project.chanyouji.Class.Tripday;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by lanouhn on 16/9/29.
 */
public class Parse {
    public static List<Tripday> gettripdayList(String obj){
        List<Tripday> tripdayList=new ArrayList<>();

        try {
            JSONObject jsonObject=new JSONObject(obj);
            if (jsonObject.has("trip_days")){
                JSONArray jsonArray=jsonObject.getJSONArray("trip_days");
                for (int i = 0; i <jsonArray.length() ; i++) {
                    JSONObject json=jsonArray.getJSONObject(i);
                    Tripday tripday=new Tripday();
                    if (json.has("trip_date")){
                        tripday.setTrip_date(json.getString("trip_date"));
                    }
                    if (json.has("nodes")){
                        JSONArray array=json.getJSONArray("nodes");
                        List<Tripday.NodesBean> nodeList=new ArrayList<>();
                        for (int a = 0; a <array.length() ; a++) {
                            Tripday.NodesBean node=new Tripday.NodesBean();
                          JSONObject json1=array.getJSONObject(a);
                            if (json1.has("comment")){
                                node.setComment(json1.getString("comment"));
                            }
                            if (json1.has("entry_name")){
                                node.setEntry_name(json1.getString("entry_name"));
                            }
                            if (json1.has("id")){
                                node.setId(json1.getInt("id"));
                            }
                            List<Tripday.NodesBean.NotesBean> notesBeanList=new ArrayList<>();
                            if (json1.has("notes")){
                                JSONArray array1=json1.getJSONArray("notes");
                                for (int b = 0; b <array1.length() ; b++) {
                                    JSONObject json2=array1.getJSONObject(b);
                                    Tripday.NodesBean.NotesBean notesBean=new Tripday.NodesBean.NotesBean();
                                    if (json2.has("description")){
                                        notesBean.setDescription(json2.getString("description"));
                                    }
                                    Tripday.NodesBean.NotesBean.PhotoBean photo=new Tripday.NodesBean.NotesBean.PhotoBean();
                                    if (json2.has("photo")){
                                        JSONObject json3=json2.getJSONObject("photo");
                                        if (json3.has("url")){
                                            photo.setUrl(json3.getString("url"));
                                        }
                                    }else {
                                           photo.setUrl("");
                                    }
                                    notesBean.setPhoto(photo);
                                    notesBeanList.add(notesBean);
                                }
                            }
                            node.setNotes(notesBeanList);
                            nodeList.add(node);
                            tripday.setNodes(nodeList);

                        }

                    }
                    tripdayList.add(tripday);

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tripdayList;
    }
    public static List<Node> getnodeList(String obj){
        List<Node> nodeList=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(obj);
            if (jsonObject.has("trip_days")){
                JSONArray jsonArray=jsonObject.getJSONArray("trip_days");
                for (int i = 0; i <jsonArray.length() ; i++) {
                    JSONObject json=jsonArray.getJSONObject(i);
                    if (json.has("nodes")){
                        JSONArray array=json.getJSONArray("nodes");
                        for (int a = 0; a <array.length() ; a++) {
                            Node node=new Node();
                            JSONObject json1=array.getJSONObject(a);
                            if (json1.has("comment")){
                                node.setComment(json1.getString("comment"));
                            }
                            if (json1.has("entry_name")){
                                node.setEntry_name(json1.getString("entry_name"));
                            }
                            if (json1.has("id")){
                                node.setId(json1.getInt("id"));
                            }
                            List<Node.NotesBean> notesBeanList=new ArrayList<>();
                            if (json1.has("notes")){
                                JSONArray array1=json1.getJSONArray("notes");
                                for (int b = 0; b <array1.length() ; b++) {
                                    JSONObject json2=array1.getJSONObject(b);
                                    Node.NotesBean notesBean=new Node.NotesBean();
                                    if (json2.has("description")){
                                        notesBean.setDescription(json2.getString("description"));
                                    }
                                    Node.NotesBean.PhotoBean photo=new Node.NotesBean.PhotoBean();
                                    if (json2.has("photo")){
                                        JSONObject json3=json2.getJSONObject("photo");
                                        if (json3.has("url")){
                                            photo.setUrl(json3.getString("url"));
                                        }
                                    }else {
                                        photo.setUrl("");
                                    }
                                    notesBean.setPhoto(photo);
                                    notesBeanList.add(notesBean);
                                }
                            }
                            node.setNotes(notesBeanList);
                            nodeList.add(node);


                        }

                    }


                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return nodeList;
    }
}
