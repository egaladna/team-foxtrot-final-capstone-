<template>
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
  </div>
</template>

<script>
import ClothingItem from "@/components/ClothingItem";
import ClosetService from "@/services/ClosetService";
// import UploadWidget from "@/components/UploadWidget.vue"


export default {
  data() {
    return {
        
    };
  },
  components: {
    ClothingItem,
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

<style>

</style>