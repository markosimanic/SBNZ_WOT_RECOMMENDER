<template>
    <div id="tanksPage">
        <div id="headline">
            <h4>YOUR PROFILE</h4>
        </div>
    <div class="card">
        <h1>Username:{{user.username}}</h1>
        <p class="title">Discount : {{user.discount}}</p>
        <p class="title">Current balance: {{user.balance}}</p>
        <p class="title">Category: {{user.userCategory}}</p>
</div>
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
        error: null,
        user : ''
    }
    }, methods : {
        getAllUserTanks(){
            this.error = null
            AXIOS.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem('token');
            AXIOS.get('/users/getAllUserTanks')
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
        },
        getUser(){
            this.error = null
            AXIOS.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem('token');
            AXIOS.get('/discounts/setDiscount')
            .then(response => {
                    if (response.status == 200){
                        this.user = response.data
                        console.log(response.data)
                    } 
                })
                .catch(err => {
                    if (err.response.status == 400) {
                        this.errorMessage = "Some error has occured!";
                        this.error = true
                        console.log(this.error)
                    } 
                })
        },
    }, mounted(){
         this.getAllUserTanks()
         this.getUser()
       
     }
 }
</script>

<style scoped>

 #table{
    position: fixed;
    top: 45%;
    left: 70%;
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
    left: 10%;
    right: 10%;
}

h4 { 
    color: #ffffff; 
    font-family: 'Raleway',sans-serif;
    font-size: 62px;
    font-weight: 800;
    line-height: 72px;
    text-transform: uppercase; 
    text-shadow: #6C6B6B;
}

.card {
position: fixed;
    top: 35%;
    left: 20%;
    transform: translate(-50%, -50%);
    width: 30%;
    height: 20%;
    background-color: rgba(182, 181, 181, 0.918);
    display: table;
    transition: opacity .3s ease;
    border-radius:20px;
    border: 1px solid black;
    border-collapse:separate;
}

.title {
  color: grey;
  font-size: 18px;
}

button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

a {
  text-decoration: none;
  font-size: 22px;
  color: black;
}

button:hover, a:hover {
  opacity: 0.7;
}


#headline{
    position:absolute;
    top:60px;
    left: 20%;
    right: 20%;
}


</style>