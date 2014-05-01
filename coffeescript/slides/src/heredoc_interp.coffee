alertMarkup = """
    <div class="alert-box alert">
      #{$.parseJSON(response.responseText).errors}
      <a href="" class="close">&times;</a>
    </div>
"""
