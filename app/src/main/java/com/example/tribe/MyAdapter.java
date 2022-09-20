package com.example.tribe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<User> list;

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = list.get(position);
        holder.Name.setText(user.getName());
        holder.familyid.setText(user.getFamilyid());
        holder.aadharno.setText(user.getAadharno());
        holder.phoneno.setText(user.getPhoneno());
        holder.organization.setText(user.getOrganization());
        holder.gender.setText(user.getGender());
        holder.marriage.setText(user.getMarriage());
        holder.religion.setText(user.getReligion());
        holder.caste.setText(user.getCaste());
        holder.age.setText(user.getAge());
        holder.relationship.setText(user.getRelationship());
        holder.qualification.setText(user.getQualification());
        holder.cert.setText(user.getCert());
        holder.emp.setText(user.getEmp());
        holder.role.setText(user.getRole());
        holder.orgname.setText(user.getOrgname());
        holder.income.setText(user.getIncome());
        holder.bankacc.setText(user.getBankacc());
        holder.bankname.setText(user.getBankname());
        holder.loan.setText(user.getLoan());
        holder.amount.setText(user.getAmount());
        holder.vechicle.setText(user.getVechicle());
        holder.highed.setText(user.getHighed());
        holder.nameofed.setText(user.getNameofed());
        holder.distanceofed.setText(user.getDistanceofed());
        holder.edexpense.setText(user.getEdexpense());
        holder.house.setText(user.getHouse());
        holder.housegiven.setText(user.getHousegiven());
        holder.housetype.setText(user.getHousetype());
        holder.property.setText(user.getProperty());
        holder.landsize.setText(user.getLandsize());
        holder.hospitaldistance.setText(user.getHospitaldistance());
        holder.healthprob.setText(user.getHealthprob());
        holder.medicinetype.setText(user.getMedicinetype());
        holder.delivery.setText(user.getDelivery());
        holder.childcaresystem.setText(user.getChildcaresystem());
        holder.illchildren.setText(user.getIllchildren());
        holder.healthissure.setText(user.getHealthissure());
        holder.tobaco.setText(user.getTobaco());
        holder.alcohol.setText(user.getAlcohol());
        holder.selfhelp.setText(user.getSelfhelp());
        holder.villagerep.setText(user.getVillagerep());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Name;
        TextView familyid;
        TextView aadharno;
        TextView phoneno;
        TextView organization;
        TextView gender;
        TextView marriage;
        TextView religion;
        TextView caste;
        TextView age;
        TextView relationship;
        TextView qualification;
        TextView cert;
        TextView emp;
        TextView role;
        TextView orgname;
        TextView income;
        TextView bankacc;
        TextView bankname;
        TextView loan;
        TextView amount;
        TextView vechicle;
        TextView highed;
        TextView nameofed;
        TextView distanceofed;
        TextView edexpense;
        TextView house;
        TextView housegiven;
        TextView housetype;
        TextView property;
        TextView landsize;
        TextView hospitaldistance;
        TextView healthprob;
        TextView medicinetype;
        TextView delivery;
        TextView childcaresystem;
        TextView illchildren;
        TextView healthissure;
        TextView tobaco;
        TextView alcohol;
        TextView selfhelp;
        TextView villagerep;



        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            Name=itemView.findViewById(R.id.rname);
            familyid =itemView.findViewById(R.id.rid);
            aadharno=itemView.findViewById(R.id.raadhar);
            phoneno=itemView.findViewById(R.id.rphno);
            organization=itemView.findViewById(R.id.rorg);
             gender=itemView.findViewById(R.id.rgender);
             marriage=itemView.findViewById(R.id.rmar);
             religion=itemView.findViewById(R.id.rreligion);
             caste=itemView.findViewById(R.id.rcaste);
             age=itemView.findViewById(R.id.rage);
             relationship=itemView.findViewById(R.id.rrel);
             qualification=itemView.findViewById(R.id.rqual);
             cert=itemView.findViewById(R.id.rcert);
             emp=itemView.findViewById(R.id.remp);
             role=itemView.findViewById(R.id.rrole);
             orgname=itemView.findViewById(R.id.rorg);
             income=itemView.findViewById(R.id.rincome);
             bankacc=itemView.findViewById(R.id.rbankacc);
             bankname=itemView.findViewById(R.id.rbname);
             loan=itemView.findViewById(R.id.rloan);
             amount=itemView.findViewById(R.id.ramount);
             vechicle=itemView.findViewById(R.id.rvehicle);
             highed=itemView.findViewById(R.id.rhighed);
             nameofed=itemView.findViewById(R.id.rnameed);
             distanceofed=itemView.findViewById(R.id.rdisted);
             edexpense=itemView.findViewById(R.id.rexp);
             house=itemView.findViewById(R.id.rhouse);
             housegiven=itemView.findViewById(R.id.rhousefrom);
             housetype=itemView.findViewById(R.id.rhtype);
             property=itemView.findViewById(R.id.rproperty);
             landsize=itemView.findViewById(R.id.rland);
             hospitaldistance=itemView.findViewById(R.id.rdist);
             healthprob=itemView.findViewById(R.id.rhealthprob);
             medicinetype=itemView.findViewById(R.id.rmedtype);
             delivery=itemView.findViewById(R.id.rdelivery);
             childcaresystem=itemView.findViewById(R.id.rchildcare);
             illchildren=itemView.findViewById(R.id.rillchild);
             healthissure=itemView.findViewById(R.id.rhealthissue);
             tobaco=itemView.findViewById(R.id.rtobaco);
             alcohol=itemView.findViewById(R.id.ralcohol);
             selfhelp=itemView.findViewById(R.id.rselfhelp);
             villagerep=itemView.findViewById(R.id.rvillage);

        }
    }
}
