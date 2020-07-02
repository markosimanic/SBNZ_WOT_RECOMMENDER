<template>
    <div id="tanksPage">
        <div id="headline">
                <h4>TANKS YOU OWN</h4>
        </div>>
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
        getAllUserTanks(){
            this.error = null
            AXIOS.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem('token');
            AXIOS.get('/users/getAllUserTanks')
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
    }, mounted(){
         this.getAllUserTanks()
     }
 }
</script>

<style scoped>

 #table{
    position: fixed;
    top: 40%;
    left: 27%;
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

</style>