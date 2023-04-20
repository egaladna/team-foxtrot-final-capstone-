<template>
  <div id="main-selection" class="view-frame">
      <OutfitSelector />
      
  </div>
</template>

<script>
import OutfitSelector from '@/components/OutfitSelector'

export default {
    components: {
        OutfitSelector,
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