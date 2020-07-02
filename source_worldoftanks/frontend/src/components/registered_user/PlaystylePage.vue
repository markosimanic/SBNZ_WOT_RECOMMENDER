<template>
    <div>
        <h1 id="mainh1">CHOOSE YOUR BEST TANK CHARACTERISTICS!</h1>
        <div id="checksDiv">
        <div id="checksInside" v-for="(item, index) in items" :key="index">
          <input type="checkbox" :id="item.name" v-model="item.checked">
          <label :for="item.name">{{ item.name }}</label>
        </div>
        <div id="tankDiv">
        </div>
        <div id="buttonDiv">
          <b-button @click="findBestTank">Submit characteristics</b-button>
        </div> 
        </div>
    </div>
</template>

<script>
import { AXIOS } from '../../http-commons'

  export default {
    name : "PlayStylePage",
    data() {
      return {
        items : [],
        names : [],
        error: null
    }
    }, methods : {
        populateChecks(){
            this.error = null
            AXIOS.get('/tanks/getAllChars')
            .then(response => {
                    if (response.status == 200){
                        localStorage.setItem('token', response.data.accessToken);
                        this.items = response.data   
                        console.log(response)    
                    } 
                })
                .catch(err => {
                    if (err.response.status == 400) {
                        this.errorMessage = "Some error has occured!";
                        this.error = true
                    } 
                })
        },findBestTank(){
            this.error = null
            AXIOS.post('/recommend/playstyle')
            .then(response => {
                    if (response.status == 200){
                        localStorage.setItem('token', response.data.accessToken);
                        this.items = response.data   
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
    },
        mounted() {
            this.populateChecks();
        }
 }
</script>


<style scoped>

#mainh1{
    color: #ffffff; 
    font-family: 'Raleway',sans-serif;
    font-size: 62px;
    font-weight: 800;
    line-height: 72px;
    margin: 0 0 24px; 
    text-align: center; 
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    margin: 0 auto;
    text-transform: uppercase; 
    text-shadow: #6C6B6B;
}

div.bottomLinks {
  display: block;
  padding: 10px;
   opacity: 0.7;
}
 a  div.bottomLinks{
  display: block;
  background-color: #000;
  color: #FFF;
}
 a:hover div.bottomLinks{
  display: block;
  background-color: #CCC;
  color: #000;
}

#container{
  width: 50%;
  margin: 0 auto;
}

#checksDiv{
    position: fixed;
    top: 20%;
    left: 20%;
    transform: translate(-50%, -50%);
    width: 30%;
    height: 15%;
    background-color: rgba(182, 181, 181, 0.918);
    display: table;
    transition: opacity .3s ease;
    border-radius:20px;
    border: 1px solid black;
    border-collapse:separate;
    opacity: 0.7;
    
}

#checksInside{
    position: relative;
    display: inline-block;
    left: 0%;
}

#tankDiv{
    position: fixed;
    top:  1%;
    left: 700px;
    width: 900px;
    height: 700px;
    background-color: rgba(182, 181, 181, 0.918);
    display: table;
    transition: opacity .3s ease;
    border-radius:20px;
    border: 1px solid black;
    border-collapse:separate;
    opacity: 0.7;
    
}

#buttonDiv{
    position: fixed;
    top:250px;
    left: 50%;
    transform: translate(-50%, -50%);
    border: 1px solid black;
    border-radius:5px;
    border: 2px solid black;
    border-collapse:separate;
}

#tankH1{
    position: fixed;
    top:  1%;
    left: 950px;
    display: table;
    color: #ffffff; 
    font-family: 'Raleway',sans-serif;
    font-size: 50px;
    font-weight: 800;
    line-height: 72px;
    
}
</style>