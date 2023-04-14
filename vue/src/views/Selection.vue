<template>
  <div id="main-selection" class="view-frame">
      <div id="item-chooser">
           <ItemChooser />
      </div>
     
      <div id="selected-items">
          <SelectedItems />
      </div>
      
  </div>
</template>

<script>
import ItemChooser from '@/components/ItemChooser'
import SelectedItems from '../components/SelectedItems.vue'

export default {
    components: {
        ItemChooser,
        SelectedItems
    }
}
</script>

<style>
#main-selection{
    display: flex;
    
}



#item-chooser,
#selected-items {
    border: solid #1B3536;
    border-radius: 8px;
    width: fit-content;
    block-size: fit-content;
    padding: 40px;
    margin-right: 10%;
}




</style>