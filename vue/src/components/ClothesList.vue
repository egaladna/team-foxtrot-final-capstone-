<template> 
<div id="closet">
  <h1>My Closet</h1>
  <div id = "clothing-items">
    <div v-for="cloth in displayedClothes" v-bind:key="cloth.id">
      <ClothingItem v-bind:cloth="cloth" />
      <i class="fa fa-trash-o" title="Delete" style="font-style:24px;" v-on:click.prevent="deleteClothingItem(cloth.id)"></i>
      <!-- <p id="msg"></p> -->
    </div>
  </div>

</div>
</template>

<script>
import ClothingItem from "@/components/ClothingItem";
import ClosetService from "@/services/ClosetService";

export default {
  data() {
    return {
      clothing: [],
    };
  },

  components: {
    ClothingItem,
  },

  methods: {
    getClothesList() {
      ClosetService.getClothingList()
        .then((response) => {
          this.clothing = response.data;
        })
        .catch((err) => {
          console.error(err);
        });
    },

    deleteClothingItem(itemId) {
      if (confirm("Are you sure you want to delete this garment? It will also be removed from any saved otufits.") == true) {
        ClosetService.deleteClothingItem(itemId).then(response => {
          if (response.status == 200) {
            this.getClothesList();
          }
        }).catch(err => console.error(err));
      } 
			
    },




  },

  computed: {
    displayedClothes() {
      return this.clothing.filter((cloth) => {
        return cloth;
      });
    },
  },

  created() {
      this.getClothesList();
  },
};
</script>

<style>
#clothing-items {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
}
#closet {
  display: flex;
  flex-direction: column;
}
</style>