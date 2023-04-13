<template>
  <div>
      <p>Selected Items</p>
      <div class="selectedItemsDiv" v-for="type in types" :key="type.id">
        <SelectedItem :type="type"/>
        </div>
      <i class="fa fa-save" title="Save" style="font-size:24px;" v-on:click.prevent="saveOutfits"></i> 
  </div>
</template>

<script>
import OutfitService from '../services/OutfitService'
import ClosetService from '../services/ClosetService'
import SelectedItem from '../components/SelectedItem.vue'
export default {
    components: {
        SelectedItem
    },
    data() {
        return {
        types: []
        }
    },
    computed: {

    },
    methods: {
        saveOutfits(){
            const cleanedUpList = this.$store.state.selectedItems.filter((item) => {
                return item.id
            }); 
            OutfitService.addOutfit(cleanedUpList);
        }
    },
    created() {
        ClosetService.getTypes().then(response => {
            this.types = response.data;
        }).catch(err => console.error(err));
    }
}
</script>
<style>

.selectedImages {
    display: flex;
    flex-direction: column;
    height: auto;
    width: 100px;
}

.selectedItemsDiv {
   border: 0;
}



</style>