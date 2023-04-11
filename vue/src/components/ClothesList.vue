<template>  
  <div id = "clothing-items">
      <h1>My Closet</h1>
    <div v-for="cloth in displayedClothes" v-bind:key="cloth.id">
      <ClothingItem v-bind:cloth="cloth" />
      <button v-on:click.prevent="deleteClothingItem(cloth.id)">Delete</button>
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
      ClosetService.deleteClothingItem(itemId).then((response) => {
        if (response.status == 200) {
          this.getClothesList();
        }
      });
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

</style>