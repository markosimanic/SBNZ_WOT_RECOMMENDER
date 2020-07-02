<template>
    
    <div id="homepage">
      <head> 
      </head>
        <div id="headline">
                <h4>Welcome to the Tank Recommender!</h4>
        </div>
        <div id="pageBody">
            <b-card header-tag="header"  border-variant="secondary" style="max-width: 50rem;" class="mb-2 mx-auto"  body-bg-variant="secondary">
              <div class="btn-group">
                <b-button v-on:click="redirect_playstyle()">RECOMMENDATION BASED ON YOUR PLAYSTYLE</b-button>
                <b-button v-on:click="redirect_good_at()">RECOMMENDATION BASED ON TANKS YOU ARE GOOD AT</b-button>
                <b-button v-on:click="redirect_owned()">RECOMMENDATION BASED ON YOUR BUYING HISTORY</b-button>
              </div>
            </b-card>
        
          <b-button v-on:click="redirect_tank_database()">SEE ALL TANKS IN OUR GAME</b-button>

        </div>
    </div>
    
    
</template>

<script>

export default {
  methods: {
      redirect_playstyle(){
        this.$router.push("/playstyle")
      },
       redirect_good_at(){
        this.$router.push("/stats")
      },
       redirect_owned(){
       this.$router.push("/yourtanks")
      },
      redirect_tank_database(){
       this.$router.push("/all")
      }
    }
}
</script>
   
<style scoped>

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
 
h3{

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

#homepage{
    opacity: 0.9; 
    display: inline-block;
    padding: 1em;
    height: 5%;
    overflow: hidden;
  
}

#headline{
    position:absolute;
    top:60px;
    left: 20%;
    right: 20%;
}

#pageBody{
    position:ce;
    top:150px;
    left: 10%;
    right: 10%;
    color: #000;

}

button {
    font-family: 'Arial black';
}

.btn-group button {
  background-color: #6B6B6B; /* Green background */
  border: 0.5px solid #ABABAB; /* Green border */
  color: white; /* White text */
  padding: 10px 24px; /* Some padding */
  cursor: pointer; /* Pointer/hand icon */
  float: left; /* Float the buttons side by side */
}

/* Clear floats (clearfix hack) */
.btn-group:after {
  content: "";
  clear: both;
  display: table;
}

/* Add a background color on hover */
.btn-group button:hover {
  background-color: #515151;
}


</style>