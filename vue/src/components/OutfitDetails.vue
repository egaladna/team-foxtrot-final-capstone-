<template>
  <div>
    <p v-if="Object.keys(outfit.itemList).length != 0">{{outfit}}</p>
  </div>
</template>

<script>
import OutfitService from "../services/OutfitService";

export default {
data() {
    return {
        outfit: {}
    }
},
created() {
    OutfitService.getOutfitById(this.$route.params.id).then(response => {
        if(response.status == 200) {
            this.outfit = response.data
        }
    }).catch(err => console.error(err));
}
};
</script>

<style>
</style>