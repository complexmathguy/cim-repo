/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.controller.query;

import com.occulue.api.*;
import com.occulue.controller.*;
import com.occulue.controller.query.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.projector.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * Implements Spring Controller query CQRS processing for entity RatioTapChanger.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RatioTapChanger")
public class RatioTapChangerQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a RatioTapChanger using a UUID
   *
   * @param UUID ratioTapChangerId
   * @return RatioTapChanger
   */
  @GetMapping("/load")
  public RatioTapChanger load(@RequestParam(required = true) UUID ratioTapChangerId) {
    RatioTapChanger entity = null;

    try {
      entity =
          RatioTapChangerBusinessDelegate.getRatioTapChangerInstance()
              .getRatioTapChanger(new RatioTapChangerFetchOneSummary(ratioTapChangerId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load RatioTapChanger using Id " + ratioTapChangerId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all RatioTapChanger business objects
   *
   * @return Set<RatioTapChanger>
   */
  @GetMapping("/")
  public List<RatioTapChanger> loadAll() {
    List<RatioTapChanger> ratioTapChangerList = null;

    try {
      // load the RatioTapChanger
      ratioTapChangerList =
          RatioTapChangerBusinessDelegate.getRatioTapChangerInstance().getAllRatioTapChanger();

      if (ratioTapChangerList != null)
        LOGGER.log(Level.INFO, "successfully loaded all RatioTapChangers");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all RatioTapChangers ", exc);
      return null;
    }

    return ratioTapChangerList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected RatioTapChanger ratioTapChanger = null;
  private static final Logger LOGGER =
      Logger.getLogger(RatioTapChangerQueryRestController.class.getName());
}
