<template>
<section class="wrappers">
  <div id="clothingList-closet">
    <h1>MY CLOSET</h1>
    <div id="clothingList-clothing-items">
      <div v-for="cloth in displayedClothes" v-bind:key="cloth.id">
        <ClothingItem v-bind:cloth="cloth" />
        
      </div>
    </div>
    <UploadFile />
  </div>
  </section>
</template>

<script>
import ClothingItem from "@/components/ClothingItem";
import ClosetService from "@/services/ClosetService";
import UploadFile from "@/components/UploadFile"


export default {
  data() {
    return {
        
    };
  },
  components: {
    ClothingItem,
    UploadFile
    //UploadWidget
  },

  methods: {
    refreshCloset() {
      ClosetService.getClothingList()
        .then((response) => {
          this.$store.commit("UPDATE_CLOSET", response.data);
        })
        .catch((err) => console.error(err));
    },

    deleteClothingItem(itemId) {
      if (
        confirm(
          "Are you sure you want to delete this garment? It will also be removed from any saved outfits."
        ) == true
      ) {
        ClosetService.deleteClothingItem(itemId)
          .then((response) => {
            if (response.status == 200) {
             this.refreshCloset();
            }
          })
          .catch((err) => console.error(err));
      }
    },

  },

  computed: {
    displayedClothes() {
      return this.$store.state.myCloset;
    },
  },

  created() {
    this.refreshCloset();
  },
};
</script>

<style scoped>
.wrappers {
  display: flex;
  justify-content: center ;
  position: absolute;
  top: 120px;
  bottom: 100px;
  left: 350px;
  right: 350px;
  box-shadow: -1px 0 15px black;
  border: 2px solid rgba(255, 255, 255, 0.1);
  border-radius: 120px;
  backdrop-filter: blur(15px); 
}

#clothingList-closet h1{
  display: flex;
  justify-content: center;
  margin-top: 30px;
  z-index: 100;
  color: #f68a3f;
  text-shadow: 3px 2px 2px black;
  font-family: 'Junge';
  font-size: 50px;
  letter-spacing: 2px;
  margin-bottom: 20px;;
  
}

#clothingList-closet {
  margin-bottom: 20px;
}


#clothingList-clothing-items {
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
  align-items: baseline;
  margin-bottom: 40px;
  border: 1px solid black;
  border-top: none;
  border-right: none;
  border-left: none;
  padding-top: 30px;
  border-radius: 55px;
  overflow: auto;
}

</style>