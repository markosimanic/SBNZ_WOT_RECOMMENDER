<template>
    <div id="tanksPage">
    <table id="table">
      <thead>
          <tr>
              <th v-for="(column, index) in columns" :key="index"> {{column}}</th>
          </tr>
      </thead>
      <tbody>
          <tr v-for="(item, index) in items" :key="index">
              <td v-for="(column, indexColumn) in columns" :key="indexColumn">{{item[column]}}</td>
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
        error: null
    }
    }, methods : {
        getAllTanks(){
            this.error = null
            AXIOS.get('/tanks/getAllTanks')
            .then(response => {
                    if (response.status == 200){
                        localStorage.setItem('token', response.data.accessToken);
                        this.items = response.data
                         console.log(this.items)
                    } 
                })
                .catch(err => {
                    if (err.response.status == 400) {
                        this.errorMessage = "Some error has occured!";
                        this.error = true
                        console.log(this.error)
                    } 
                })
        }
    } , mounted(){
         this.getAllTanks()
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

</style>