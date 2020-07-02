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
        columns : ["avgDamage", "winRate","gunMark"],
        items : [],
        error: null
    }
    }, methods : {
        getStats(){
            this.error = null
            AXIOS.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem('token');
            AXIOS.get('/statistics/current')
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
         this.getStats()
     }
 }
</script>

<style lang="stylus" scoped>

</style>