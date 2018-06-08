package com.thread.test1;

import java.util.Arrays;
import java.util.List;

/**
 * @Author tom
 * @Date 2018-03-30 11:22
 */

public class test {
  public final static  String Tablename="act_ge_property;act_re_model;act_ru_job;act_ru_event_subscr;act_evt_log;act_procdef_info;act_re_deployment;act_ge_bytearray;act_ru_execution;act_re_procdef;act_hi_procinst;act_ru_task;act_ru_identitylink;act_ru_variable;act_hi_actinst;act_hi_taskinst;act_hi_varinst;act_hi_detail;act_hi_comment;act_hi_attachment;act_hi_identitylink;act_id_group;act_id_membership;act_id_user;act_id_info;xxl_job_qrtz_calendars;xxl_job_qrtz_fired_triggers;xxl_job_qrtz_locks;xxl_job_qrtz_paused_trigger_grps;xxl_job_qrtz_scheduler_state;xxl_job_qrtz_trigger_group;xxl_job_qrtz_trigger_info;xxl_job_qrtz_trigger_log;xxl_job_qrtz_trigger_logglue;xxl_job_qrtz_trigger_registry;xxl_job_qrtz_triggers;xxl_job_qrtz_blob_triggers;xxl_job_qrtz_cron_triggers;xxl_job_qrtz_simple_triggers;xxl_job_qrtz_simprop_triggers;xxl_job_qrtz_job_details;crm_node_wechat;crm_node_wechat_tags;crm_node_withdraw;crm_node_relation;crm_wechat_send;crm_bi_board;crm_bi_board_bu;crm_bi_board_param;crm_bi_category;crm_bi_dataset;crm_bi_datasource;crm_bi_widget;crm_sms_send;crm_api_interface;crm_api_mock;crm_api_project;crm_brand;crm_campaign_customer_tag;crm_api_user_permission;crm_api_test_history;crm_api_user;crm_campaign_customer_tag_rule;crm_campaign_customer_tag_type;crm_campaign_segment;crm_channel;crm_channel_wechat_burger_test;crm_club;crm_coupon_test;crm_campaign;crm_member;crm_member_address;crm_member_coupon_batch_test;crm_member_kids;crm_member_log;crm_member_mail;crm_member_media_account;crm_member_order_tags;crm_member_phone;crm_member_privilege;crm_member_tags_array;crm_campaign_audit;crm_order;crm_order_detail;crm_order_tags;crm_order_tags_bak;crm_order_transaction_detail;crm_order_transaction_tender;crm_outside_data;crm_outside_data_list;crm_platform_user;crm_point_rules;crm_privilege;crm_campaign_rule;crm_product;crm_product_bak;crm_product_category;crm_sales;crm_sys_data_auth;crm_sys_dept;crm_sys_element;crm_sys_gate_client;crm_sys_gate_client_service;crm_sys_gate_log;crm_sys_group;crm_sys_group_leader;crm_sys_group_member;crm_sys_group_type;crm_sys_menu;crm_sys_resource_authority;crm_sys_role;crm_sys_login_log;crm_sys_status_color;crm_sys_user;crm_sys_user_role;crm_template_mail;crm_template_sms;crm_template_wechat;crm_tmp_tags;crm_user_defined_tag;crm_sys_role_menu;crm_channel_mail;crm_channel_sms;crm_channel_wechat;crm_event;crm_event_rule;crm_mail_send;crm_node;crm_node_buy;crm_node_buy_store;crm_node_coupon;crm_node_coupon_effective;crm_node_coupon_expire;crm_node_coupon_send;crm_node_coupon_verification;crm_node_degrade;crm_node_feedback;crm_node_filter;crm_node_grading;crm_node_mail;crm_node_points;crm_node_points_accrual;crm_node_points_redeem;crm_node_register;crm_node_register_store;crm_node_schedule;crm_node_segment;crm_node_sms;crm_node_upgrade;crm_node_wait;crm_sys_dict;crm_coupon;crm_grade;crm_member_tags;crm_point_type;crm_point_rules_condition_group;crm_point_rules_condition;crm_order_payment;crm_member_point_detail_history;crm_member_point_detail;crm_member_grade_history;crm_member_coupon_use;crm_member_point;crm_member_coupon;crm_coupon_rule;crm_campaign_segment_type";
  public final  static  String type="N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;Y;Y;Y;Y;Y;Y;Y;N;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;N;N;N;N;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;N;N;N;Y;Y;Y;Y;Y;Y;Y;N;Y;N;N;N;N;N;N;Y;Y;Y;Y;Y;Y;N;N;N;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;N;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;Y;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;N;Y;Y;Y;N;Y;Y;Y;Y;Y;Y;Y;Y;Y;N;Y;Y";
  public final static String filler="act_evt_log;act_ge_bytearray;act_ge_property;act_hi_actinst;act_hi_attachment;act_hi_comment;act_hi_detail;act_hi_identitylink;act_hi_procinst;act_hi_taskinst;act_hi_varinst;act_id_group;act_id_info;act_id_membership;act_id_user;act_procdef_info;act_re_deployment;act_re_model;act_re_procdef;act_ru_event_subscr;act_ru_execution;act_ru_identitylink;act_ru_job;act_ru_task;act_ru_variable;crm_api_interface;crm_api_mock;crm_api_project;crm_api_test_history;crm_api_user;crm_api_user_permission;crm_brand;crm_campaign_customer_tag;crm_campaign_customer_tag_rule;crm_campaign_customer_tag_type;crm_campaign_segment_type;crm_channel;crm_channel_wechat_burger_test;crm_club;crm_coupon;crm_coupon_rule;crm_coupon_test;crm_grade;crm_member_address;crm_member_coupon;crm_member_coupon_batch_test;crm_member_coupon_use;crm_member_grade_history;crm_member_kids;crm_member_log;crm_member_mail;crm_member_media_account;crm_member_order_tags;crm_member_phone;crm_member_point;crm_member_point_detail;crm_member_point_detail_history;crm_member_privilege;crm_member_tags;crm_member_tags_array;crm_node_buy;crm_node_buy_store;crm_node_coupon;crm_node_coupon_effective;crm_node_coupon_expire;crm_node_coupon_send;crm_node_coupon_verification;crm_node_degrade;crm_node_feedback;crm_node_filter;crm_node_grading;crm_node_mail;crm_node_points;crm_node_points_accrual;crm_node_points_redeem;crm_node_register;crm_node_register_store;crm_node_schedule;crm_node_segment;crm_node_sms;crm_node_upgrade;crm_node_wait;crm_node_wechat;crm_node_wechat_tags;crm_node_withdraw;crm_order;crm_order_detail;crm_order_payment;crm_order_tags;crm_order_tags_bak;crm_order_transaction_detail;crm_order_transaction_tender;crm_outside_data;crm_outside_data_list;crm_platform_user;crm_point_rules;crm_point_rules_condition;crm_point_rules_condition_group;crm_point_type;crm_privilege;crm_product;crm_product_bak;crm_product_category;crm_sales;crm_sys_data_auth;crm_sys_dept;crm_sys_element;crm_sys_gate_client;crm_sys_gate_client_service;crm_sys_gate_log;crm_sys_group;crm_sys_group_leader;crm_sys_group_member;crm_sys_group_type;crm_sys_menu;crm_sys_resource_authority;crm_sys_role;crm_sys_status_color;crm_sys_user;crm_sys_user_role;crm_template_mail;crm_template_sms;crm_template_wechat;crm_tmp_tags;crm_user_defined_tag;xxl_job_qrtz_blob_triggers;xxl_job_qrtz_calendars;xxl_job_qrtz_cron_triggers;xxl_job_qrtz_fired_triggers;xxl_job_qrtz_job_details;xxl_job_qrtz_locks;xxl_job_qrtz_paused_trigger_grps;xxl_job_qrtz_scheduler_state;xxl_job_qrtz_simple_triggers;xxl_job_qrtz_simprop_triggers;xxl_job_qrtz_trigger_group;xxl_job_qrtz_trigger_info;xxl_job_qrtz_trigger_log;xxl_job_qrtz_trigger_logglue;xxl_job_qrtz_trigger_registry;xxl_job_qrtz_triggers";
  public final static String Pre_Nexport="./pg_dump -U postgres -s -c--encoding=utf-8 -f /data/dabaseBack/n.sql";
  public final static String pre_Yexport="./pg_dump -U postgres -c --encoding=utf-8 -f /data/dabaseBack/y.sql";
  public final static String _export=" crm";
  public final static String aimport="psql -d crm -p 5632 -f e:\\s.sql -U postgres";
/*  psql -d crm -p 5632 -f e:\n.sql -U postgres
  psql -d crm -p 5632 -f e:\y.sql -U postgres*/
/* /pg_dump -U postgres   -f /dabaseBack/s.sql -t crm_campaign_segment_type  crm
* pg_dump -U postgres  -f /s.sql -t crm_campaign_segment_type  postgres*/
  public static void main(String[] args) {
      String[]datas=Tablename.split(";");
      //String[]fillers=filler.split(";");
      String[]fillers={};
      List<String> list= Arrays.asList(fillers);
      String[]types=type.split(";");
      StringBuffer ydataexport=new StringBuffer();
      StringBuffer ndataexport=new StringBuffer();
    ndataexport.append(Pre_Nexport);
    ydataexport.append(pre_Yexport);
    for (int i = 0; i <datas.length ; i++) {
     if(list.contains(datas[i])){
       continue;
     }
      if ("N".equals(types[i])){

        ndataexport.append(" -t "+datas[i]);
      }else{
        ydataexport.append(" -t "+datas[i]);

      }
      
    }
    ndataexport.append(_export);
    ydataexport.append(_export);
    System.out.println(ndataexport);

    System.out.println(ydataexport);
  }
}
