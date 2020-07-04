<template>
     <div id="tanksPage">
    <!-- <b-table id="table" striped hover :items="items" :fields="fields"></b-table> -->
    <table id="table">
      <thead>
          <tr>
            <th>Tank</th>
            <th>Average damage</th>
            <th>Win rate</th>
            <th>Gun mark</th>
          </tr>
      </thead>
      <tbody>
          <tr v-for="item in items" :key="item.name">
              <td>{{item.userTank.tank.name}}</td>
              <td>{{item.avgDamage}}</td>
              <td>{{item.winRate}}</td>
              <td>{{item.gunMark}}</td>
          </tr>
      </tbody>
    </table>
    <div id="bestTankDiv">
        <h1 id="recommendType">You are winning most battles with {{userBestWRTank.name}}, Recommendation: play {{userBestWRTank.tankType}} tanks.</h1>
        <p id="recStringDiv">{{recommendationString}}</p>
    </div>    
    </div>
</template>

<script>
import { AXIOS } from '../../http-commons'

  export default {
    name : "AllTanksPage",
    data() {
      return {
         fields : [
            { key: 'userTank', label: 'Tank' },
            { key: 'avgDamage', label: 'Average damage' },
            { key: 'winRate', label: 'Win rate' },
            { key: 'gunMark', label: 'Gun mark' },
          ],
        items : [],
        error: null,
        userBestWRTank : '',
        recommendationString : ''
    }
    }, methods : {
        getStats(){
            this.error = null
            AXIOS.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem('token');
            AXIOS.get('/statistics/current')
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
        }, getUser(){
            this.error = null
            AXIOS.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem('token');
            AXIOS.get('/users/getUser')
            .then(response => {
                    if (response.status == 200){
                        this.userBestWRTank = response.data.bestStatsTank
                        this.recommendationString = response.data.recommendationString
                        console.log(this.recommendationString)
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
    } , mounted(){
         this.getStats()
         this.getUser()
     }
 }
</script>

<style scoped>

 #table{
    position: fixed;
    top: 20%;
    left: 50%;
    transform: translate(-50%, -50%);
    width: 70%;
    height: 30%;
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

#bestTankDiv{
    position: fixed;
    top: 70%;
    left: 50%;
    transform: translate(-50%, -50%);
}

#recommendType{
     text-shadow: #6C6B6B;
    display: inline-block;
    text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
}

#recStringDiv{
 background-color: rgba(182, 181, 181, 0.918);
}

h1{
     color: #ffffff; 
    font-family: 'Raleway',sans-serif;
    font-size: 40px;
    font-weight: 800;
    line-height: 72px;
    margin: 0 0 24px; 
     display: inline-block;
    top: 0;
    left: 0;
    right: 0;
    margin: 0 auto;
    text-transform: uppercase; 
    text-shadow: #6C6B6B;
}

</style>