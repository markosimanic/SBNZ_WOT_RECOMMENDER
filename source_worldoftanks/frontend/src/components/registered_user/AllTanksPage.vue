<template>
    <div id="tanksPage">
    <table id="table">
      <thead>
          <tr>
            <th>Tank</th>
            <th>Tank status</th>
            <th>Tank Type</th>
          </tr>
      </thead>
      <tbody>
          <tr v-for="item in items" :key="item.name">
              <td>{{item.name}}</td>
              <td>{{item.tankStatus}}</td>
              <td>{{item.tankType}}</td>
              <td><b-button id="buyButton" @click="buyTank(item.id)">BUY</b-button></td>
          </tr>
      </tbody>
    </table>
    </div>
</template>

<script>
import { AXIOS } from '../../http-commons'

  export default {
    name : "AllTanksPage",
    data() {
      return {
        columns : ["name", "tankType"],
        items : [],
        chars : [],
        error: null,
    }
    }, methods : {
        getAllTanks(){
            this.error = null
            AXIOS.get('/tanks/getAllTanks')
            .then(response => {
                    if (response.status == 200){
                        this.items = response.data
                    } 
                })
                .catch(err => {
                    if (err.response.status == 400) {
                        this.errorMessage = "Some error has occured!";
                        this.error = true
                        console.log(this.error)
                    } 
                })
        },populateChecks(){
            this.error = null
            AXIOS.get('/tanks/getAllChars')
            .then(response => {
                    if (response.status == 200){
                        this.chars = response.data   
                        console.log(response)    
                    } 
                })
                .catch(err => {
                    if (err.response.status == 400) {
                        this.errorMessage = "Some error has occured!";
                        this.error = true
                    } 
                })
        },
           buyTank(id){
            this.error = null
            AXIOS.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem('token');
            AXIOS.post('/discounts/buyTank?tankId='+id)
            .then(response => {
                    if (response.status == 200){
                         this.$fire({
                            title: "Tank bought successfully!",
                            type: "success",
                            timer: 3000
                    });
                    } 
                })
                .catch(err => {
                    if (err.response.status == 400) {
                        this.$fire({
                            title: "You already own this tank or you don't have enough money!",
                            type: "error",
                            timer: 3000
                    });
                    } 
                })
        }
    }, mounted(){
         this.getAllTanks()
         this.populateChecks()
     }
 }
</script>

<style scoped>

 #table{
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    width: 50%;
    height: 50%;
    background-color: rgba(182, 181, 181, 0.918);
    display: table;
    transition: opacity .3s ease;
     border-radius:20px;
    border: 1px solid black;
    border-collapse:separate;
  
   
 }

 th, td{
     border-left:solid black 1px;
    border-top:solid black 1px;
 }

 th {
    border-top: none;
}

td:first-child, th:first-child {
     border-left: none;
}

#headline{
    position:absolute;
    top:60px;
    left: 20%;
    right: 20%;
}

h4 { 
    color: #ffffff; 
    font-family: 'Raleway',sans-serif;
    font-size: 62px;
    font-weight: 800;
    line-height: 72px;
    margin: 0 0 24px; 
    text-align: center; 
    text-transform: uppercase; 
    text-shadow: #6C6B6B;
}

#characteristics{
    position: fixed;
    top: 26%;
    left: 50%;
    transform: translate(-50%, -50%);
    width: 30%;
    height: 10%;
    background-color: rgba(182, 181, 181, 0.918);
    display: table;
    transition: opacity .3s ease;
    border-radius:20px;
    border: 1px solid black;
    border-collapse:separate;
    opacity: 0.9;
}

#checksInside{
    display: inline-block;
}

#buttonDiv{
     position: fixed;
    top: 41%;
    left: 50%;
    transform: translate(-50%, -50%);
    border: 1px solid black;
    border-radius:5px;
    border: 2px solid black;
    border-collapse:separate;
}

#buyButton{

}
</style>