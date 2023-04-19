<template>
<section class="wrappers">
  <div id="clothingList-closet">
    <h1>My Closet</h1>
    <div id="clothingList-clothing-items">
      <div v-for="cloth in displayedClothes" v-bind:key="cloth.id">
        <ClothingItem v-bind:cloth="cloth" />
        <i
          class="fa fa-trash-o"
          title="Delete"
          style="font-style: 24px"
          v-on:click.prevent="deleteClothingItem(cloth.id)"
        ></i>
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
  box-shadow: -1px 0 10px rgba(0, 0, 0, 0.6);
  border: 2px solid rgba(255, 255, 255, 0.1);
  border-radius: 25px;
  backdrop-filter: blur(10px);
  overflow: auto;
}
#clothingList-closet h1{
  display: flex;
  justify-content: center;
  margin-top: 30px;
  z-index: 100;
  color: #EBEFD1;
  font-size: 30px;
  
}


#clothingList-clothing-items {
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
  align-items: baseline;
  margin-top: 50px;
  
}

</style>